package telran.cars.controllers;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import telran.cars.dto.*;
import telran.cars.model.IRentCompany;
import telran.cars.utils.Persistable;

import java.util.List;

@RestController
public class AdministartorController {

@Autowired
    IRentCompany service;

    @Value("${fileName:company.data}")
    private String fileName;

    @PostMapping("/car/add")
    CarsReturnCode addCar(@RequestBody Car car){
        return service.addCar(car);
    }

    @PostMapping("/model/add")
    CarsReturnCode addModel(@RequestBody Model model){
        return service.addModel(model);
    }

    @DeleteMapping("/car/remove")
    RemovedCarData removeCar(@RequestParam String regNumber){
        return service.removeCar(regNumber);
    }

    @DeleteMapping("/model/remove")
    List<RemovedCarData> removeCarsOfModel(@RequestParam String modelName){
        return service.removeCarsOfModel(modelName);
    }

    @PreDestroy
    public void saveCompanyToFile(){
        if(service instanceof Persistable) {
            ((Persistable)service).save(fileName);
        }
    }
}
