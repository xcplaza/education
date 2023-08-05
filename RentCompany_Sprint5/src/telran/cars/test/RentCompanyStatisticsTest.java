package telran.cars.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import telran.cars.dto.Car;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.model.IRentCompany;
import telran.cars.model.RentCompanyEmbedded;

public class RentCompanyStatisticsTest {
	private static final String MODEL = "model";
	private static final String CAR = "car";

	IRentCompany company = new RentCompanyEmbedded();
	int[] prices = { 100, 100, 100, 100, 10000 };
	int[] years = { 2000, 1995, 1950, 1948 };
	LocalDate fromDate = LocalDate.of(1900, 1, 1);
	LocalDate toDate = LocalDate.of(2100, 1, 1);
	LocalDate rentDate = LocalDate.of(2020, 1, 1);

	@Before
	public void setUp() throws Exception {
		createModels();
		createCars();
		createDrivers();
		rentReturns();
	}

	private void rentReturns() {
		int[] license = { 0, 0, 1, 1, 2, 2, 3, 3, 0 };
		String[] regNumbers = { CAR + 0, CAR + 1, CAR + 0, CAR + 1, CAR + 2, CAR + 3, CAR + 2, CAR + 3, CAR + 4 };
		assertTrue(regNumbers.length == license.length);
		int rentDays = 5;
		for (int i = 0; i < regNumbers.length; i++) {
			company.rentCar(regNumbers[i], license[i], rentDate, rentDays);
			company.returnCar(regNumbers[i], license[i], rentDate.plusDays(rentDays), 0, 100);
			rentDate = rentDate.plusDays(rentDays + 1);
		}

	}

	private void createDrivers() {
		for (int licenseId = 0; licenseId < years.length; licenseId++) {
			company.addDriver(new Driver(licenseId, "name", years[licenseId], "phone"));
		}

	}

	private void createCars() {
		for (int i = 0; i < prices.length; i++) {
			company.addCar(new Car(CAR + i, "color", MODEL + i));
		}
	}

	private void createModels() {
		for (int i = 0; i < prices.length; i++) {
			company.addModel(new Model(MODEL + i, 50, "company", "country", prices[i]));
		}
	}

	@Test
	public void testGetMostPopularCarModels() {
		int ageYoungFrom = rentDate.getYear() - years[0];
		int ageYoungTo = rentDate.getYear() - years[1] + 1;
		int ageOldFrom = rentDate.getYear() - years[2];
		int ageOldTo = rentDate.getYear() - years[3] + 1;

		List<String> youngModels = company.getMostPopularCarModels(fromDate, toDate, ageYoungFrom, ageYoungTo);
		assertEquals(2, youngModels.size());
		assertTrue(youngModels.contains(MODEL + 0));
		assertTrue(youngModels.contains(MODEL + 1));
		List<String> oldModels = company.getMostPopularCarModels(fromDate, toDate, ageOldFrom, ageOldTo);
		assertEquals(2, oldModels.size());
		assertTrue(oldModels.contains(MODEL + 2));
		assertTrue(oldModels.contains(MODEL + 3));

	}

	@Test
	public void testGetMostProfitableCarModels() {
		List<String> profitableModels = company.getMostProfitableCarModels(fromDate, toDate);
		assertEquals(1, profitableModels.size());
		assertEquals(MODEL + 4, profitableModels.get(0));
	}

	@Test
	public void testGetMostActiveDriver() {
		List<Driver> activeDrivers = company.getMostActiveDriver();
		assertEquals(1, activeDrivers.size());
		assertEquals(0L, activeDrivers.get(0).getLicenseId());

	}

}
