package cars.service;

import cars.domain.entities.Car;
import cars.domain.entities.Model;
import cars.domain.entities.Owner;
import cars.domain.repo.CarsRepository;
import cars.domain.repo.ModelsRepository;
import cars.domain.repo.OwnersRepository;
import cars.domain.view.ColorCount;
import cars.domain.view.ModelAge;
import cars.domain.view.ModelCount;
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
    OwnersRepository ownersRepo;
    ModelsRepository modelsRepo;

    @Autowired
    public CarsJPA(CarsRepository carsRepo, OwnersRepository ownersRepo, ModelsRepository modelsRepo) {
        this.carsRepo = carsRepo;
        this.ownersRepo = ownersRepo;
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
        Owner owner = ownersRepo.findById(carDTO.getOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner isn't exists"));
        Car car = new Car(carDTO.getRegNumber(), carDTO.getColor(), carDTO.getPurchaseDate(), model, owner);
        carsRepo.save(car);
        return true;
    }

    @Override
    public boolean addModel(ModelDTO modelDTO) {
        if (modelDTO == null || modelsRepo.existsById(modelDTO.getModelName()))
            return false;
        Model model = new Model(modelDTO.getModelName(), modelDTO.getVolume(), modelDTO.getCompany());
        modelsRepo.save(model);
        return true;
    }

    @Override
    public boolean addOwner(OwnerDTO ownerDTO) {
        if (ownerDTO == null || modelsRepo.existsById(ownerDTO.getName()))
            return false;
        Owner owner = new Owner(ownerDTO.getId(), ownerDTO.getName(), ownerDTO.getBirthYear(), new ArrayList<>());
        ownersRepo.save(owner);
        return true;
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
        return toModelDTO(getModelEntities(modelName));
    }

    private Model getModelEntities(final String modelName) {
        return modelsRepo.findById(modelName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Model isn't exists"));
    }

    private ModelDTO toModelDTO(Model model) {
        return new ModelDTO(model.modelName, model.volume, model.company);
    }

    @Override
    public OwnerDTO getOwner(int ownerId) {
        return toOwnerDTO(getOwnerEntities(ownerId));
    }

    private Owner getOwnerEntities(final int ownerId) {
        return ownersRepo.findById(ownerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner isn't exists"));
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
        Owner owner = ownersRepo.findById(ownerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner isn't exists"));
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
        if (!modelsRepo.existsById(modelName))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Model isn't exists");
        List<Car> list = carsRepo.findByModelModelName(modelName);
        return toListCarDTO(list);
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

    @Override
    public List<CarDTO> getCarsByYear(final int year) {
        if (year > LocalDate.now().getYear())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Year isn't correct");
        Car car = getCarEntities(year);
        List<Car> list = car.owner.cars;
        return toListCarDTO(list);
    }

    //    @Override
//    @Transactional(readOnly = true)
//    public List<CarDTO> getCarsByOwnerAges(final int ageFrom, final int ageTo) {
//        if (ageTo > LocalDate.now().getYear() || ageFrom > ageTo || ageFrom < 0)
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "Date is wrong");
//        LocalDate from = LocalDate.now().minusYears(ageFrom);
//        LocalDate to = LocalDate.now().minusYears(ageTo);
//        Owner owner = ownersRepo.findByBirthYearBetween(from, to);
//        List<Car> list = owner.cars;
//        if (list == null || list.isEmpty())
//            return new ArrayList<>();
//        return toListCarDTO(list);
    @Override
    @Transactional(readOnly = true)
    public List<CarDTO> getCarsByOwnerAges(int ageFrom, int ageTo) {
        int birthYearFrom = LocalDate.now().minusYears(ageTo).getYear();
        int birthYearTo = LocalDate.now().minusYears(ageFrom).getYear();
        List<Owner> owners = ownersRepo.findByBirthYearBetween(birthYearFrom, birthYearTo);
        List<Car> list = owners.stream().map(o -> o.cars).flatMap(l -> l.stream()).toList();
        if (list == null || list.isEmpty())
            return new ArrayList<>();
        return toListCarDTO(list);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OwnerDTO> getOwnersByModel(final String modelName) {
        if (!modelsRepo.existsById(modelName))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Model isn't exists");
//        Model model = modelsRepo.findById(modelName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Model isn't exists"));
        List<Car> cars = carsRepo.findByModelModelName(modelName);
        List<Owner> list = cars.stream().map(c -> c.owner).distinct().collect(Collectors.toList());
        if (list == null || list.isEmpty())
            return new ArrayList<>();
        return list.stream().map(this::toOwnerDTO).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public boolean removeOwner(final int ownerId) {
        if (!ownersRepo.existsById(ownerId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner isn't exists");
        carsRepo.deleteAllByOwnerId(ownerId);
        ownersRepo.deleteById(ownerId);
        return true;
    }

    @Override
    @Transactional
    public int removeCarsOlderThanYearsFromDate(int years, LocalDate current) {
        if (current == null)
            current = LocalDate.now();
        if (years > LocalDate.now().getYear())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Year isn't correct");
        LocalDate line = current.minusYears(years);
        List<Car> cars = carsRepo.findByPurchaseDateBetween(LocalDate.of(1990, 1, 1), line);
        long count = cars.stream().count();
        carsRepo.deleteAll(cars);
        return (int) count;
    }

    @Override
    @Transactional
    public boolean purchaseCar(long regNumber, int ownerId, LocalDate purchaseDate) {
        if (regNumber < 0)
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Wrong registration number");
        if (!carsRepo.existsById(regNumber))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Car is already exists");
        if (purchaseDate.isBefore(LocalDate.now()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Wrong purchase date");
        Car car = getCarEntities(regNumber);
        Owner owner = ownersRepo.findById(ownerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner isn't exists"));
        car.owner = owner;
        car.purchaseDate = purchaseDate;
        return true;
    }

    //    агрегатные методы
    @Override
    public List<ModelCount> getModelsCount() {
        return carsRepo.getModelsCount();
    }

    @Override
    public List<OwnerDTO> getOwnersCarsAmount(int amount) {
        List<Owner> list = ownersRepo.getOwnersCarsAmount(amount);
        return list.stream().map(this::toOwnerDTO).collect(Collectors.toList());
    }

    @Override
    public List<ModelDTO> getMostPopularModels() {
        List<Model> list = modelsRepo.getMostPopularModels();
        return list.stream().map(this::toModelDTO).collect(Collectors.toList());
    }

    @Override
    public List<String> getMostPopularModelNamesPurchasedDateBetweenOwnersAgeBetween(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge) {
        int birthYearFrom = LocalDate.now().getYear() - toAge;
        int birthYearTo = LocalDate.now().getYear() - fromAge;
        return carsRepo.getModelDateAge(fromDate, toDate, birthYearFrom, birthYearTo);
    }

    @Override
    public List<ColorCount> getColorCounts() {
        return carsRepo.getColorCounts();
    }

    @Override
    public List<ModelAge> getModelsAvgAge() {
        return carsRepo.getModelsAvgAge();
    }

    @Override
    public List<OwnerDTO> getOldestOwner(List<Owner> owners) {
        return owners.stream().map(this::toOwnerDTO).toList();
    }


}
