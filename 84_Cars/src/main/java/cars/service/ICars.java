package cars.service;

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

//    Получить все машины, купленные в переданном году
    List<CarDTO> getCarsByYear(int year);
//    Получить все машины, купленные водителями указанного возраста
    List<CarDTO> getCarsByOwnerAges(int ageFrom, int ageTo);
//    Получить всех водителей, владеющих машинами какой-то модели
    List<OwnerDTO> getOwnersByModel(String modelName);
//    Удалить владельца. Должны быть удалены и машины, принадлежащие этому владельцу
    boolean removeOwner(int ownerId);
//    Удалить все машины, приобретенные более чем какое-то количество лет с переданной даты. Если текущая дата не задана, то берется текущая дата. Возвращает количество удаленных машин
    int removeCarsOlderThanYearsFromDate(int years, LocalDate current );
//    Оформляем покупку машины переданным владельцем с этим регистрационным номером, и датой. Если дата не передана, то считается текущая дата
    boolean purchaseCar(long regNumber, int ownerId, LocalDate purchaseDate) ;
}
