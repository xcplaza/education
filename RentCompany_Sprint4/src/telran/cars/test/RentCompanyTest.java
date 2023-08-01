package telran.cars.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import telran.cars.dto.Car;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.dto.RemovedCarData;
import telran.cars.dto.RentRecord;
import telran.cars.model.IRentCompany;
import telran.cars.model.RentCompanyEmbedded;
import telran.util.Persistable;

public class RentCompanyTest {
	private static final String MODEL_NAME = "BMW X6";
	private static final int GAS_TANK = 50;
	private static final int PRICE_DAY = 500;
	private static final long LICENSE = 123;
	private static final String REG_NUMBER = "A123";
	private static final String FILE_NAME = "company.data";
	static Model model = new Model(MODEL_NAME, GAS_TANK, "BMW", "Germany", PRICE_DAY);
	static Car car = new Car(REG_NUMBER, "black", MODEL_NAME);
	static Driver driver = new Driver(LICENSE, "Max", 1980, "322223");
	static IRentCompany company;

//	Sprint2
	private static final int RENT_DAYS = 5;
	private static final int YEAR = 2018;
	private static final int MONTH = 12;
	private static final int DAY = 2;
	private static final LocalDate RENT_DATE = LocalDate.of(YEAR, MONTH, DAY);
	
//	Sprint3
	private static final int FINE_PERCENT = 15;
	private static final int GAS_PRICE = 10;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		company = new RentCompanyEmbedded();
		company.addModel(model);
		company.addCar(car);
		company.addDriver(driver);
		company.rentCar(REG_NUMBER, LICENSE, RENT_DATE, RENT_DAYS);
		((Persistable) company).save(FILE_NAME);

	}

	@Before
	public void setUp() throws Exception {
		company = RentCompanyEmbedded.restoreFromFile(FILE_NAME);

	}

	@Test
	public void testGets() {
		Model actualModel = company.getModel(MODEL_NAME);
		assertEquals(model, actualModel);
		Car actualCar = company.getCar(REG_NUMBER);
		assertEquals(car, actualCar);
		Driver actualDriver = company.getDriver(LICENSE);
		assertEquals(driver, actualDriver);
	}

	@Test
	public void testAddCar() {
		Car newCar = new Car(REG_NUMBER, "black", MODEL_NAME);
		assertEquals(CarsReturnCode.CAR_EXISTS, company.addCar(newCar));
		newCar = new Car(REG_NUMBER + 111, "black", MODEL_NAME + "M");
		assertEquals(CarsReturnCode.NO_MODEL, company.addCar(newCar));
		newCar = new Car(REG_NUMBER + 111, "red", MODEL_NAME);
		assertEquals(CarsReturnCode.OK, company.addCar(newCar));
	}

	@Test
	public void testAddModel() {
		assertEquals(CarsReturnCode.MODEL_EXISTS, company.addModel(model));
		Model newModel = new Model(MODEL_NAME + "*", 50, "company", "country", PRICE_DAY);
		assertEquals(CarsReturnCode.OK, company.addModel(newModel));
	}

	@Test
	public void testAddDriver() {
		assertEquals(CarsReturnCode.DRIVER_EXISTS, company.addDriver(driver));
		Driver newDriver = new Driver(LICENSE + 10, "model name", 1980, "123456789");
		assertEquals(CarsReturnCode.OK, company.addDriver(newDriver));
	}

	public void rentCarTest() {
		assertEquals(CarsReturnCode.NO_CAR, company.rentCar(REG_NUMBER + "111", LICENSE, RENT_DATE, RENT_DAYS));
		assertEquals(CarsReturnCode.CAR_IN_USE, company.rentCar(REG_NUMBER, LICENSE, RENT_DATE, RENT_DAYS));

		Car car1 = new Car(REG_NUMBER + 1, "red", MODEL_NAME);
		company.addCar(car1);

		assertEquals(CarsReturnCode.NO_DRIVER, company.rentCar(REG_NUMBER + 1, LICENSE + 1, RENT_DATE, RENT_DAYS));
		car1.setFlRemoved(true);
		assertEquals(CarsReturnCode.CAR_REMOVED, company.rentCar(REG_NUMBER + 1, LICENSE, RENT_DATE, RENT_DAYS));
	}

	@Test
	public void getRentRecordsTest() {
		RentRecord expected = new RentRecord(REG_NUMBER, LICENSE, RENT_DATE, RENT_DAYS);
		List<RentRecord> records = company.getRentRecordsAtDates(RENT_DATE, RENT_DATE.plusDays(RENT_DAYS));
		assertEquals(1, records.size());
		assertEquals(expected, records.get(0));
		records = company.getRentRecordsAtDates(RENT_DATE.minusDays(1), RENT_DATE);
		assertTrue(records.isEmpty());

	}

	@Test
	public void getCarsDriverTest() {
		List<Car> cars = company.getDriverCars(LICENSE);
		assertEquals(1, cars.size());
		assertEquals(car, cars.get(0));
		cars = company.getDriverCars(LICENSE + 100);
		assertTrue(cars.isEmpty());
	}

	@Test
	public void getDriversCarTest() {
		List<Driver> drivers = company.getCarDrivers(REG_NUMBER);
		assertEquals(1, drivers.size());
		assertEquals(driver, drivers.get(0));
		drivers = company.getCarDrivers(REG_NUMBER + "111");
	}

	@Test
	public void getModelCars() {
		List<Car> cars = company.getModelCars(MODEL_NAME);
		assertTrue(cars.isEmpty());// car1 is in use
		Car car2 = new Car(REG_NUMBER + "111", "green", MODEL_NAME);
		company.addCar(car2);
		cars = company.getModelCars(MODEL_NAME);
		assertEquals(1, cars.size());
		assertEquals(car2, cars.get(0));
		cars = company.getModelCars(MODEL_NAME + "YYY");
		assertTrue(cars.isEmpty());// model doesn't exist
	}
	
	//Sprint3

	@Test
	public void removeCarInUseTest() {
		assertNull(company.removeCar(REG_NUMBER + "1"));

		RemovedCarData rcd = company.removeCar(REG_NUMBER);
		Car car = rcd.getCar();
		assertNotNull(company.getCar(REG_NUMBER));
		assertTrue(car.isFlRemoved());
		assertNull(rcd.getRemovedRecords());

	}

	@Test
	public void removeCarNotInUseTest() {
		LocalDate returnDate = RENT_DATE.plusDays(RENT_DAYS);
		company.returnCar(REG_NUMBER, LICENSE, returnDate, 0, 100);
		RemovedCarData rcd = company.removeCar(REG_NUMBER);
		testActualRemoved(returnDate, rcd);
	}

	private void testActualRemoved(LocalDate returnDate, RemovedCarData rcd) {
		List<RentRecord> records = rcd.getRemovedRecords();
		assertNotNull(records);
		assertEquals(1, records.size());
		RentRecord record = records.get(0);
		assertEquals(REG_NUMBER, record.getRegNumber());
		assertEquals(returnDate, record.getReturnDate());
		assertNull(company.getCar(REG_NUMBER));
		assertTrue(company.getRentRecordsAtDates(RENT_DATE, RENT_DATE.plusDays(RENT_DAYS)).isEmpty());
		assertTrue(company.getCarDrivers(REG_NUMBER).isEmpty());
		assertTrue(company.getDriverCars(LICENSE).isEmpty());
		List<Car> carsModel = company.getModelCars(MODEL_NAME);
		assertTrue(carsModel.isEmpty() || carsModel.stream().allMatch(c -> c.isFlRemoved()));
	}
	
	@Test
	public void removeModelTest()
	{
		assertTrue(company.removeModel(MODEL_NAME + "11").isEmpty());
		assertFalse(company.removeModel(MODEL_NAME).isEmpty());
		Car car = company.getCar(REG_NUMBER);
		assertTrue(car.isFlRemoved());
	}
	
	@Test
	public void returnCarWithRemoving()
	{
		// after return car with flRemoved=true
		// actual removing
		company.removeCar(REG_NUMBER);
		LocalDate returnDate = RENT_DATE.plusDays(RENT_DAYS);
		RemovedCarData rcd = company.returnCar(REG_NUMBER, LICENSE, returnDate, 0, 100);
		testActualRemoved(returnDate, rcd);
	}

	@Test
	public void returnCarWithNoDamagesNoDelayFullTank()
	{
		LocalDate returnDate = RENT_DATE.plusDays(RENT_DAYS);
		RentRecord recordExpected = new RentRecord(REG_NUMBER, LICENSE, RENT_DATE, RENT_DAYS);
		double cost=PRICE_DAY * RENT_DAYS;
		int damages = 0;
		int tankPercent = 100;
		setRecordExpected(returnDate, recordExpected, cost, damages, tankPercent);
		company.returnCar(REG_NUMBER, LICENSE, returnDate, 0, 100);
		List<RentRecord> records = company.getRentRecordsAtDates(RENT_DATE, returnDate);
		assertEquals(1,records.size());
		assertEquals(recordExpected,records.get(0));
	}
	
	@Test
	public void returnCarWithDelay() 
	{
		//delay 1 day
		LocalDate returnDate = RENT_DATE.plusDays(RENT_DAYS+1);
		RentRecord recordExpected = new RentRecord(REG_NUMBER, LICENSE, RENT_DATE, RENT_DAYS);
		double cost = PRICE_DAY * RENT_DAYS + PRICE_DAY + PRICE_DAY / 100. * FINE_PERCENT;
		int damages = 0;
		int tankPercent = 100;
		setRecordExpected(returnDate, recordExpected, cost, damages, tankPercent);
		company.returnCar(REG_NUMBER, LICENSE, returnDate, 0, 100);
		List<RentRecord> records = company.getRentRecordsAtDates(RENT_DATE, returnDate);
		assertEquals(1,records.size());
		assertEquals(recordExpected,records.get(0));
	}
	
	@Test
	public void returnCarWithNoFullTank() 
	{
		//Tank percent=50
		LocalDate returnDate = RENT_DATE.plusDays(RENT_DAYS);
		RentRecord recordExpected = new RentRecord(REG_NUMBER, LICENSE, RENT_DATE, RENT_DAYS);
		double cost = PRICE_DAY * RENT_DAYS + GAS_TANK / 2 * GAS_PRICE;
		int damages = 0;
		int tankPercent = 50;
		setRecordExpected(returnDate, recordExpected, cost, damages, tankPercent);
		company.returnCar(REG_NUMBER, LICENSE, returnDate, 0, tankPercent);
		List<RentRecord> records = company.getRentRecordsAtDates(RENT_DATE, returnDate);
		assertEquals(1,records.size());
		assertEquals(recordExpected,records.get(0));
	}
	
	@Test
	public void returnCarWithTotalLostDamages() 
	{
		LocalDate returnDate = RENT_DATE.plusDays(RENT_DAYS);
		RentRecord recordExpected = new RentRecord(REG_NUMBER, LICENSE, RENT_DATE, RENT_DAYS);
		double cost = PRICE_DAY * RENT_DAYS;
		int damages = 70;
		int tankPercent = 100;
		setRecordExpected(returnDate, recordExpected, cost, damages, tankPercent);
		RemovedCarData rcd = company.returnCar(REG_NUMBER, LICENSE, returnDate, damages, 
				tankPercent);
		//with damages greater than 50 - actual removing
		Car car = company.getCar(rcd.getCar().getRegNumber());
		assertNull(car);
	}
	
	private void setRecordExpected(LocalDate returnDate, RentRecord recordExpected, double cost, 
			int damages, int tankPercent) 
	{
		recordExpected.setCost(cost);
		recordExpected.setTankPercent(tankPercent);
		recordExpected.setDamages(damages);
		recordExpected.setReturnDate(returnDate);
	}

}
