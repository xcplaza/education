package telran.cars.model;
import java.io.Serializable;
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
}
