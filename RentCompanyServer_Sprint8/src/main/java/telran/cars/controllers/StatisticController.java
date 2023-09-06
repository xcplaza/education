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
public class StatisticController {

	@Autowired
	IRentCompany service;

	@DateTimeFormat(iso = ISO.DATE)
	@GetMapping("/records/{from}/{to}")
	List<RentRecord> getRentRecordsAtDates(@PathVariable String from, String to) {
		LocalDate fromDate = LocalDate.parse(from);
		LocalDate toDate = LocalDate.parse(to);
		return service.getRentRecordsAtDates(fromDate, toDate);
	}

	@DateTimeFormat(iso = ISO.DATE)
	@GetMapping("/models/popular/{dateFrom}/{dateTo}/{ageFrom}/{ageTo}")
	List<String> getMostPopularCarModels(@PathVariable String dateFrom, String dateTo, String ageFrom, String ageTo) {

		LocalDate fromDate = LocalDate.parse(dateFrom);
		LocalDate toDate = LocalDate.parse(dateTo);
		int fromAge = Integer.parseInt(ageFrom);
		int toAge = Integer.parseInt(ageTo);
		return service.getMostPopularCarModels(fromDate, toDate, fromAge, toAge);
	}

	@DateTimeFormat(iso = ISO.DATE)
	@GetMapping("/models/profitable/{dateFrom}/{dateTo}")
	List<String> getMostProfitableCarModels(@PathVariable String dateFrom, String dateTo) {
		LocalDate fromDate = LocalDate.parse(dateFrom);
		LocalDate toDate = LocalDate.parse(dateTo);
		return service.getMostProfitableCarModels(fromDate, toDate);
	}

	@GetMapping("/drivers/active")
	List<Driver> getMostActiveDriver() {
		return service.getMostActiveDriver();
	}

}
