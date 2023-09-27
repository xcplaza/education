package telran.cars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telran.cars.dto.Car;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.dto.RemovedCarData;
import telran.cars.dto.RentCarData;
import telran.cars.dto.ReturnCarData;
import telran.cars.model.IRentCompany;

@RestController
public class ClerkController
{
	@Autowired
	IRentCompany service;

	@GetMapping("/driver/{licenseId}/cars")
	List<Car> getCarsByDriver(@PathVariable long licenseId)
	{
		return service.getCarsByDriver(licenseId);
	}

	@GetMapping("/models")
	List<String> getModelNames()
	{
		return service.getModelNames();
	}

	@PostMapping(value = "/driver/add")
	CarsReturnCode addDriver(@RequestBody Driver driver)
	{
		return service.addDriver(driver);
	}

	@GetMapping(value = "/model")
	Model getModel(@RequestParam String modelName)
	{
		return service.getModel(modelName);
	}

	@GetMapping(value = "/car")
	Car getCar(@RequestParam String regNumber)
	{
		return service.getCar(regNumber);
	}

	@GetMapping(value = "/car/{regNumber}/drivers")
	List<Driver> getCarDrivers(@PathVariable String regNumber)
	{
		return service.getDriversByCar(regNumber);
	}

	@GetMapping(value = "/model/{modelName}/cars")
	List<Car> getModelCars(@PathVariable String modelName)
	{
		return service.getCarsByModel(modelName);
	}

	@PostMapping(value = "/car/return")
	RemovedCarData returnCar(@RequestBody ReturnCarData rcd)
	{
		return service.returnCar(rcd.getRegNumber(), rcd.getLicenseId(), rcd.getReturnDate(), 
				rcd.getDamages(), rcd.getTankPercent());
	}

	@PostMapping(value = "/car/rent")
	CarsReturnCode rentCar(@RequestBody RentCarData rcd)
	{
		return service.rentCar(rcd.getRegNumber(), rcd.getLicenseId(), rcd.getRentDate(), 
				rcd.getRentDays());
	}

	@GetMapping(value = "/driver")
	Driver getDriver(@RequestParam long licenseId)
	{
		return service.getDriver(licenseId);
	}

}
