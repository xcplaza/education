package telran.cars.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import telran.cars.dto.Driver;
import telran.cars.dto.RentRecord;
import telran.cars.model.IRentCompany;

@RestController
public class StatisticController
{
	@Autowired
	IRentCompany service;
	
	@DateTimeFormat(iso = ISO.DATE)
	@GetMapping("/records/{from}/{to}")
	List<RentRecord> getRentRecordsAtDates(@PathVariable String from, 
			@PathVariable String to)
	{
		LocalDate fromDate = LocalDate.parse(from);
		LocalDate toDate = LocalDate.parse(to);
		return service.getRentRecordsAtDates(fromDate, toDate);
	}
		
	@GetMapping("/models/popular/{dateFrom}/{dateTo}/{ageFrom}/{ageTo}")
	List<String> getMostPopularCarModels(@PathVariable("dateFrom") 
	@DateTimeFormat(iso = ISO.DATE) String fromDate,
			@PathVariable("dateTo") @DateTimeFormat(iso = ISO.DATE) String toDate, @PathVariable int ageFrom,
			@PathVariable int ageTo)
	{
		LocalDate from = LocalDate.parse(fromDate);
		LocalDate to = LocalDate.parse(toDate);
		return service.getMostPopularCarModels(from, to, ageFrom, ageTo);
	}

	@GetMapping("/models/profitable/{dateFrom}/{dateTo}")
	@DateTimeFormat(iso = ISO.DATE)
	List<String> getMostProfitableCarModels(@PathVariable String dateFrom, 
			@PathVariable String dateTo)
	{
		LocalDate from = LocalDate.parse(dateFrom);
		LocalDate to = LocalDate.parse(dateTo);
		return service.getMostProfitableCarModels(from, to);
	}
	
	@GetMapping("/drivers/active")
	List<Driver> getMostActiveDriver()
	{
		return service.getMostActiveDriver();
	}
}
