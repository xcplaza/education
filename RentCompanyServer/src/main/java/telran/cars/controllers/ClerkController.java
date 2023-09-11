package telran.cars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import telran.cars.dto.*;
import telran.cars.model.IRentCompany;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ClerkController {

    @Autowired
    IRentCompany service;

    @PostMapping("/driver/add")
    CarsReturnCode addDriver(@RequestBody  Driver driver){
        return service.addDriver(driver);
    }

    @GetMapping("/car")
    Car getCar(@RequestParam String regNumber){
        return service.getCar(regNumber);
    }

    @GetMapping("/model")
    Model getModel(@RequestParam String modelName){
        return service.getModel(modelName);
    }

    @GetMapping("/driver")
    Driver getDriver(@RequestParam long licenseId){
        return service.getDriver(licenseId);
    }

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @PostMapping("/car/rent")
    CarsReturnCode rentCar(@RequestBody String regNumber, @RequestBody long licenseId, @RequestBody LocalDate rentDate, @RequestBody int rentDays){
//        LocalDate rentD = LocalDate.parse(rentDate);
        return service.rentCar(regNumber, licenseId, rentDate, rentDays);
    }

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @PostMapping("/car/return")
    RemovedCarData returnCar(@RequestBody String regNumber, @RequestBody long licenseId, @RequestBody LocalDate returnDate, @RequestBody int damages, @RequestBody int tankPercent){
//        LocalDate retD = LocalDate.parse(returnDate);
        return service.returnCar(regNumber, licenseId, returnDate, damages, tankPercent);
    }

    @GetMapping("/models")
    List<String> getModelNames(){
        return service.getModelNames();
    }

    @GetMapping("/driver/{licenseId}/cars")
    List<Car> getCarsByDriver(@PathVariable long licenseId){
        return service.getCarsByDriver(licenseId);
    }

    @GetMapping("/car/{regNumber}/drivers")
    List<Driver> getDriversByCar(@PathVariable String regNumber){
        return service.getDriversByCar(regNumber);
    }

    @GetMapping("/model/{modelName}/cars")
    List<Car> getCarsByModel(@PathVariable String modelName){
        return service.getCarsByModel(modelName);
    }
}
