package telran.cars.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import telran.util.Persistable;
import telran.cars.dto.*;

@SuppressWarnings("serial")
public class RentCompanyEmbeded extends AbstractRentCompany implements Persistable {
	HashMap<String, Car> cars = new HashMap<>();
	HashMap<Long, Driver> drivers = new HashMap<>();
	HashMap<String, Model> models = new HashMap<>();

	@Override
	public CarsRetunCode addModel(Model model) {
		return models.putIfAbsent(model.getModelName(), model) == null ? CarsRetunCode.OK : CarsRetunCode.MODEL_EXISTS;
	}

	@Override
	public Model getModel(String modelName) {
		return models.get(modelName);
	}

	@Override
	public CarsRetunCode addCar(Car car) {
		if (!models.containsKey(car.getModelName()))
			return CarsRetunCode.NO_MODEL;
		return cars.putIfAbsent(car.getRegNumber(), car) == null ? CarsRetunCode.OK : CarsRetunCode.CAR_EXISTS;
	}

	@Override
	public Car getCar(String regNumber) {
		return cars.get(regNumber);
	}

	@Override
	public CarsRetunCode addDriver(Driver driver) {
		return drivers.putIfAbsent(driver.getLicenseId(), driver) == null ? CarsRetunCode.OK
				: CarsRetunCode.DRIVER_EXISTS;
	}

	@Override
	public Driver getDriver(long licenseId) {
		return drivers.get(licenseId);
	}

	@Override
	public void save(String fileName) {
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName))) {
			output.writeObject(this);
		} catch (Exception e) {
			System.out.println("Error in method save " + e.getMessage());
		}
	}

	public static IRentCompany restoreFromFile(String fileName) {
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
			return (IRentCompany) input.readObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new RentCompanyEmbeded();
		}
	}

}
