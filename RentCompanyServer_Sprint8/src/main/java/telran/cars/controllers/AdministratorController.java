package telran.cars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.annotation.PreDestroy;
import telran.cars.dto.Car;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.Model;
import telran.cars.dto.RemovedCarData;
import telran.cars.model.IRentCompany;
import telran.cars.utils.Persistable;

@RestController
public class AdministratorController {

	@Autowired
	IRentCompany service;

	@Value("${fileName:company.data}")
	private String fileName;

	@PostMapping("/car/add")
	CarsReturnCode addCar(@RequestBody Car car) {
		return service.addCar(car);
	}

	@PostMapping("/model/add")
	CarsReturnCode addModel(@RequestBody Model model) {
		return service.addModel(model);
	}

	@DeleteMapping("/car/remove")
	RemovedCarData removeCar(@RequestParam String regNumber) {
		return service.removeCar(regNumber);
	}

	@DeleteMapping("/model/remove")
	List<RemovedCarData> removeCarsOfModel(@RequestParam String modelName) {
	return service.removeCarsOfModel(modelName);
	}

	@PreDestroy
	public void saveCompanyToFile() {
		if (service instanceof Persistable)
			((Persistable) service).save(fileName);
	}

}
