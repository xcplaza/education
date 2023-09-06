package telran.cars.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import telran.cars.dto.Car;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.dto.RemovedCarData;
import telran.cars.model.IRentCompany;

//Аttention!!! not ready!

@RestController
public class ClerlController {

	@Autowired
	IRentCompany service;

	CarsReturnCode addDriver(Driver driver) {

		return service.addDriver(driver);
	}

	Car getCar(String regNumber) {

		return service.getCar(regNumber);
	}

	Model getModel(String modelName) {

		return service.getModel(modelName);
	}

	Driver getDriver(long licenseId) {

		return service.getDriver(licenseId);
	}

	CarsReturnCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays) {

		return service.rentCar(regNumber, licenseId, rentDate, rentDays);
	}

	RemovedCarData returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages, int tankPercent) {

		return null;
	}

	List<String> getModelNames() {
		return null;
	}

	List<Car> getCarsByDriver(long licenseId) {

		return null;
	}

	List<Driver> getDriversByCar(String regNumber) {

		return null;
	}

	List<Car> getCarsByModel(String modelName) {

		return null;
	}

}
