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

//    @GetMapping("/models/popular/{dateFrom}/{dateTo}/{ageFrom}/{ageTo}")
//    List<String> getMostPopularCarModels(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge){
//        return null;
//    }
//
//    @GetMapping("/models/profitable/{dateFrom}/{dateTo}")
//    List<String> getMostProfitableCarModels(LocalDate fromDate, LocalDate toDate){
//        return null;
//    }

    @GetMapping("/drivers/active")
    List<Driver> getMostActiveDriver(){
        return service.getMostActiveDriver();
    }
}
