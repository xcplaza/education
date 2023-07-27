package telran.cars.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import telran.cars.dto.Car;
import telran.cars.dto.CarsRetunCode;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.model.IRentCompany;
import telran.cars.model.RentCompanyEmbeded;
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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		company = new RentCompanyEmbeded();
		company.addModel(model);
		company.addCar(car);
		company.addDriver(driver);
		((Persistable) company).save(FILE_NAME);
	}

	@Before
	public void setUp() throws Exception {
		company = RentCompanyEmbeded.restoreFromFile(FILE_NAME);
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
		assertEquals(CarsRetunCode.CAR_EXISTS, company.addCar(newCar));
		newCar = new Car(REG_NUMBER + 111, "black", MODEL_NAME + "M");
		assertEquals(CarsRetunCode.NO_MODEL, company.addCar(newCar));
		newCar = new Car(REG_NUMBER + 111, "red", MODEL_NAME);
		assertEquals(CarsRetunCode.OK, company.addCar(newCar));
	}

	@Test
	public void testAddDriver() {
		assertEquals(CarsRetunCode.DRIVER_EXISTS, company.addDriver(driver));
		Driver newDriver = new Driver(LICENSE, "Max", 1980, "322223");
		assertEquals(CarsRetunCode.DRIVER_EXISTS, company.addDriver(newDriver));
		newDriver = new Driver(LICENSE + 123, "Max", 1980, "322223");
		assertEquals(CarsRetunCode.OK, company.addDriver(newDriver));
		newDriver = new Driver(LICENSE + 123, "Ivan", 1970, "564987");
		assertEquals(CarsRetunCode.DRIVER_EXISTS, company.addDriver(newDriver));
	}

	@Test
	public void testAddModel() {
		assertEquals(CarsRetunCode.MODEL_EXISTS, company.addModel(model));
		Model newModel = new Model(MODEL_NAME, GAS_TANK, "BMW", "Germany", PRICE_DAY);
		assertEquals(CarsRetunCode.MODEL_EXISTS, company.addModel(newModel));
		newModel = new Model(MODEL_NAME + "M", GAS_TANK, "BMW", "Germany", PRICE_DAY);
		assertEquals(CarsRetunCode.OK, company.addModel(newModel));
		newModel = new Model(MODEL_NAME + "M", GAS_TANK, "AUDI", "Germany", PRICE_DAY);
		assertEquals(CarsRetunCode.MODEL_EXISTS, company.addModel(newModel));
	}

}
