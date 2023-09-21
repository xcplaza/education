package cars.service;

import cars.domain.entities.Car;
import cars.domain.entities.Model;
import cars.domain.entities.Owner;
import cars.domain.repo.CarsRepository;
import cars.domain.repo.ModelsRepository;
import cars.domain.repo.OwnersRepository;
import cars.dto.CarDTO;
import cars.dto.ModelDTO;
import cars.dto.OwnerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarsJPA implements ICars {
    CarsRepository carsRepo;
    OwnersRepository ownerRepo;
    ModelsRepository modelsRepo;

    @Autowired
    public CarsJPA(CarsRepository carsRepo, OwnersRepository ownerRepo, ModelsRepository modelsRepo) {
        this.carsRepo = carsRepo;
        this.ownerRepo = ownerRepo;
        this.modelsRepo = modelsRepo;
    }

    @Override
    @Transactional
    public boolean addCar(CarDTO carDTO) {
        if (carDTO.getPurchaseDate().isAfter(LocalDate.now()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Car from the future");
        if (carsRepo.existsById(carDTO.getRegNumber()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Car is already exists");
        Model model = modelsRepo.findById(carDTO.getModelName()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Model isn't exists"));
        Owner owner = ownerRepo.findById(carDTO.getOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner isn't exists"));
        Car car = new Car(carDTO.getRegNumber(), carDTO.getColor(), carDTO.getPurchaseDate(), model, owner);
        carsRepo.save(car);
        return true;
    }

    @Override
    public boolean addModel(ModelDTO modelDTO) {
        return false;
    }

    @Override
    public boolean addOwner(OwnerDTO ownerDTO) {
        return false;
    }

    @Override
    public CarDTO getCar(long regNumber) {
        return toCarDTO(getCarEntities(regNumber));
    }

    private CarDTO toCarDTO(Car car) {
        return new CarDTO(car.regNumber, car.color, car.purchaseDate, car.model.modelName, car.owner.id);
    }

    private Car getCarEntities(long regNumber) {
        return carsRepo.findById(regNumber).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car isn't exists"));
    }

    @Override
    public ModelDTO getModel(String modelName) {
        return null;
    }

    @Override
    public OwnerDTO getOwner(int ownerId) {
        return null;
    }

    @Override
    public OwnerDTO getCarOwner(long regNumber) {
        Car car = getCarEntities(regNumber);
        return toOwnerDTO(car.owner);
    }

    private OwnerDTO toOwnerDTO(Owner owner) {
        return new OwnerDTO(owner.id, owner.name, owner.birthYear);
    }

    @Override
//    @Transactional(readOnly = true) // Transactional - от spring!!! или fetch = FetchType.EAGER в Owner
    public List<CarDTO> getCarsByOwner(int ownerId) {
        Owner owner = ownerRepo.findById(ownerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner isn't exists"));
        List<Car> list = owner.cars;
        if (list == null || list.isEmpty())
            return new ArrayList<>();
        return toListCarDTO(list);
    }

    private List<CarDTO> toListCarDTO(List<Car> list) {
        return list.stream().map(this::toCarDTO).collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> getCarsByModel(String modelName) {
        return null;
    }

    @Override
    @Transactional
    public boolean removeModel(String modelName) {
        if (!modelsRepo.existsById(modelName))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car isn't exists");
//        не требуеся при включении каскадного удаления авто при удалении модели
        List<Car> list = carsRepo.findByModelModelName(modelName);
        list.forEach(c -> carsRepo.delete(c)); // удаляем авто из листа
//
        modelsRepo.deleteById(modelName); // удаляем модель всех этих авто
        return true;
    }
}
