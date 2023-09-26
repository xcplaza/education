package cars.controllers;

import java.time.LocalDate;
import java.util.List;

import cars.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import cars.service.ICars;


@RestController
public class CarsController
{
	@Autowired
	ICars service;

	@PostMapping("/car")
	public boolean addCar(@RequestBody CarDTO carDto)
	{
		return service.addCar(carDto);
	}

	@GetMapping("/car/{regNumber}")
	public CarDTO getCar(@PathVariable long regNumber)
	{
		return service.getCar(regNumber);
	}

	@GetMapping("/cars/owner/{ownerId}")
	public List<CarDTO> getCarsByOwner(@PathVariable int ownerId)
	{
		return service.getCarsByOwner(ownerId);
	}

	@GetMapping("/cars/model/{modelName}")
	public List<CarDTO> getCarsByModel(@PathVariable String modelName)
	{
		return service.getCarsByModel(modelName);
	}

	@GetMapping("/cars/year/{year}")
	public List<CarDTO> getCarsByYear(@PathVariable int year)
	{
		return service.getCarsByYear(year);
	}

	@GetMapping("/cars/owners/{ageFrom}/{ageTo}")
	public List<CarDTO> getCarsByOwnerAges(@PathVariable int ageFrom, @PathVariable int ageTo)
	{
		return service.getCarsByOwnerAges(ageFrom, ageTo);
	}

	@DeleteMapping("/cars/{years}/{current}")
	@DateTimeFormat(iso = ISO.DATE)
	public int removeCarsOlderThanYearsFromDate(int years, String current)
	{
		LocalDate date = LocalDate.parse(current);
		return service.removeCarsOlderThanYearsFromDate(years, date);
	}

	@PatchMapping("/car/{regNumber}/{ownerId}/{purchaseDate}")
	public boolean purchaseCar(@PathVariable long regNumber, @PathVariable int ownerId, 
			@PathVariable LocalDate purchaseDate)
	{
		return service.purchaseCar(regNumber, ownerId, purchaseDate);
	}
}
