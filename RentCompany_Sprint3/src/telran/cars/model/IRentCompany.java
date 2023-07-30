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

	CarsRetunCode addModel(Model model);
	Model getModel(String modelName);
	CarsRetunCode addCar(Car car);
	Car getCar(String regNumber);
	CarsRetunCode addDriver(Driver driver);
	Driver getDriver(long licenseId);

//	sprint2
	CarsRetunCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays);
	List<Car> getDriverCars(long licenseId);
	List<Driver> getCarDrivers(String regNumString);
	List<Car> getModelCars(String modelName);
	List<RentRecord> getRentRecordsAtDates(LocalDate fromDate, LocalDate toDate);
	
//	sprint3
	RemovedCarData removeCar(String regNumber);
	List<RemovedCarData> removeModel(String modelName);
	RemovedCarData returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages, int tankPersent);
}
