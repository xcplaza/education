package telran.cars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import telran.cars.dto.Driver;
import telran.cars.dto.RentRecord;
import telran.cars.model.IRentCompany;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StatisticController {
    @Autowired
    IRentCompany service;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @GetMapping("/records/{from}/{to}")
    List<RentRecord> getRentRecordsAtDates(@PathVariable String from, @PathVariable String to){
        LocalDate fromDate = LocalDate.parse(from);
        LocalDate toDate = LocalDate.parse(to);
        return service.getRentRecordsAtDates(fromDate, toDate);
    }

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @GetMapping("/models/popular/{dateFrom}/{dateTo}/{ageFrom}/{ageTo}")
    List<String> getMostPopularCarModels(@PathVariable String dateFrom, @PathVariable String dateTo, @PathVariable int ageFrom, @PathVariable int ageTo){
        LocalDate fromD = LocalDate.parse(dateFrom);
        LocalDate toD = LocalDate.parse(dateTo);
        return service.getMostPopularCarModels(fromD, toD, ageFrom, ageTo);
    }

    @GetMapping("/models/profitable/{dateFrom}/{dateTo}")
    List<String> getMostProfitableCarModels(@PathVariable String dateFrom, @PathVariable String dateTo){
        LocalDate fromDate = LocalDate.parse(dateFrom);
        LocalDate toDate = LocalDate.parse(dateTo);
        return service.getMostProfitableCarModels(fromDate, toDate);
    }

    @GetMapping("/drivers/active")
    List<Driver> getMostActiveDriver(){
        return service.getMostActiveDriver();
    }
}
