package telran.cars.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import telran.cars.dto.*;

public interface IRentCompany extends Serializable {
	int getGasPrice();
	void setGasPrice(int price);
	int getFinePercent();
	void setFinePercent(int percent);

	CarsReturnCode addModel(Model model);
	Model getModel(String modelName);
	CarsReturnCode addCar(Car car);
	Car getCar(String regNumber);
	CarsReturnCode addDriver(Driver driver);
	Driver getDriver(long licenseId);

//	Sprint2
	CarsReturnCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays);
	List<Car> getDriverCars(long licenseId);
	List<Driver> getCarDrivers(String regNumber);
	List<Car> getModelCars(String modelName);
	List<RentRecord> getRentRecordsAtDates(LocalDate fromDate, LocalDate toDate);

//	Sprint3
	RemovedCarData removeCar(String regNumber);
	List<RemovedCarData> removeModel(String modelName);
	RemovedCarData returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages, int tankPercent);

//	Sprint4
	List<String> getMostPopularCarModels(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge);
	List<String> getMostProfitableCarModels(LocalDate fromDate, LocalDate toDate);
	List<Driver> getMostActiveDriver();
}
