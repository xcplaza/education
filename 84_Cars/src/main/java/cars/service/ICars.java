package cars.service;

import cars.domain.entities.Owner;
import cars.domain.view.ColorCount;
import cars.domain.view.ModelAge;
import cars.domain.view.ModelCount;
import cars.dto.CarDTO;
import cars.dto.ModelDTO;
import cars.dto.OwnerDTO;

import java.time.LocalDate;
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

    List<CarDTO> getCarsByYear(int year); //Получить все машины, купленные в переданном году
    List<CarDTO> getCarsByOwnerAges(int ageFrom, int ageTo); //    Получить все машины, купленные водителями указанного возраста
    List<OwnerDTO> getOwnersByModel(String modelName); //    Получить всех водителей, владеющих машинами какой-то модели
    boolean removeOwner(int ownerId); //    Удалить владельца. Должны быть удалены и машины, принадлежащие этому владельцу
    int removeCarsOlderThanYearsFromDate(int years, LocalDate current ); //    Удалить все машины, приобретенные более чем какое-то количество лет с переданной даты. Если текущая дата не задана, то берется текущая дата. Возвращает количество удаленных машин
    boolean purchaseCar(long regNumber, int ownerId, LocalDate purchaseDate); //    Оформляем покупку машины переданным владельцем с этим регистрационным номером, и датой. Если дата не передана, то считается текущая дата

//    принимаем данные из агрегативных таблиц SQL
    List<ModelCount> getModelsCount();
    List<OwnerDTO> getOwnersCarsAmount(int amount);

//    native SQL
    List<ModelDTO> getMostPopularModels();
    List<String> getMostPopularModelNamesPurchasedDateBetweenOwnersAgeBetween(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge);

    List<ColorCount> getColorCounts(); //    how many cars with each color
    List<ModelAge> getModelsAvgAge(); //    average age of owner of each model name (Mersedes-35, bmw-20)
    List<OwnerDTO> getOldestOwner(List<Owner> owners); //    get owners with greater than average age of all owners
}
