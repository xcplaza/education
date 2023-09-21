package cars.service;

import cars.dto.CarDTO;
import cars.dto.ModelDTO;
import cars.dto.OwnerDTO;

import java.util.List;

public interface ICars {
    boolean addCar(CarDTO carDTO);
    boolean addModel(ModelDTO modelDTO);
    boolean addOwner(OwnerDTO ownerDTO);
    CarDTO getCar(long regNumber);
    ModelDTO getModel(String modelName);
    OwnerDTO getOwner(int ownerId);

    OwnerDTO getCarOwner(long regNumber);
    List<CarDTO> getCarsByOwner(int ownerId);
    List<CarDTO> getCarsByModel(String modelName);
    boolean removeModel(String modelName);
}
