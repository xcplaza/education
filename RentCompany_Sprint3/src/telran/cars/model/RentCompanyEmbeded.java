package telran.cars.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import telran.util.Persistable;
import telran.cars.dto.*;

@SuppressWarnings("serial")
public class RentCompanyEmbeded extends AbstractRentCompany implements Persistable {
	private static final int REMOVE_THRESHOLD = 60;
	private static final int BAD_THRESHOLD = 30;
	private static final int GOOD_THRESHOLD = 10;
	HashMap<String, Car> cars = new HashMap<>();
	HashMap<Long, Driver> drivers = new HashMap<>();
	HashMap<String, Model> models = new HashMap<>();
//	sprint2
	HashMap<String, List<Car>> modelCars = new HashMap<>();
	HashMap<Long, List<RentRecord>> driverRecords = new HashMap<>();
	HashMap<String, List<RentRecord>> carRecords = new HashMap<>();
	TreeMap<LocalDate, List<RentRecord>> records = new TreeMap<>();

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
		boolean res = cars.putIfAbsent(car.getRegNumber(), car) == null;
		if (!res) {
			return CarsRetunCode.CAR_EXISTS;
		}
		addModelCars(car);
		return CarsRetunCode.OK;
	}

	private void addModelCars(Car car) {
		String modelName = car.getModelName();
		List<Car> listCar = modelCars.getOrDefault(modelName, new ArrayList<>());
		listCar.add(car);
		modelCars.putIfAbsent(modelName, listCar);
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

	@Override
	public CarsRetunCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays) {
		Car car = getCar(regNumber);
		if (car == null) {
			return CarsRetunCode.NO_CAR;
		}
		if (car.isFlRemoved()) {
			return CarsRetunCode.CAR_REMOVED;
		}
		if (car.isInUse()) {
			return CarsRetunCode.CAR_IN_USE;
		}
		if (!drivers.containsKey(licenseId)) {
			return CarsRetunCode.NO_DRIVER;
		}
		RentRecord record = new RentRecord(regNumber, licenseId, rentDate, rentDays);
		addToCarRecord(record);
		addToDriverRecords(record);
		addToRecords(record);
		car.setInUse(true);
		return CarsRetunCode.OK;
	}

	private void addToRecords(RentRecord record) {
		String regNumber = record.getRegNumber();
		List<RentRecord> listRecords = carRecords.getOrDefault(regNumber, new ArrayList<>());
		listRecords.add(record);
		carRecords.putIfAbsent(regNumber, listRecords);
	}

	private void addToDriverRecords(RentRecord record) {
		long licenseId = record.getLicenseId();
		List<RentRecord> listRecords = driverRecords.getOrDefault(licenseId, new ArrayList<>());
		listRecords.add(record);
		driverRecords.putIfAbsent(licenseId, listRecords);
	}

	private void addToCarRecord(RentRecord record) {
		LocalDate rentDate = record.getRentDate();
		List<RentRecord> listRecords = records.getOrDefault(rentDate, new ArrayList<>());
		listRecords.add(record);
		records.putIfAbsent(rentDate, listRecords);
	}

	@Override
	public List<Car> getDriverCars(long licenseId) {
		List<RentRecord> listRecords = driverRecords.getOrDefault(licenseId, new ArrayList<>());
		return listRecords.stream().map(r -> getCar(r.getRegNumber())).distinct().toList();
	}

	@Override
	public List<Driver> getCarDrivers(String regNumString) {
		List<RentRecord> listRecords = carRecords.getOrDefault(regNumString, new ArrayList<>());
		return listRecords.stream().map(d -> getDriver(d.getLicenseId())).distinct().toList();
	}

	@Override
	public List<Car> getModelCars(String modelName) {
		List<Car> carList = modelCars.getOrDefault(modelName, new ArrayList<>());
		return carList.stream().filter(c -> !c.isFlRemoved() && !c.isInUse()).toList();
	}

	@Override
	public List<RentRecord> getRentRecordsAtDates(LocalDate fromDate, LocalDate toDate) {
		Collection<List<RentRecord>> collRecords = records.subMap(fromDate, toDate).values();
		return collRecords.stream().flatMap(l -> l.stream()).toList();
	}

	@Override
	public RemovedCarData removeCar(String regNumber) {
		Car car = getCar(regNumber);
		if (car == null || car.isFlRemoved())
			return null;
		car.setFlRemoved(true);
		return car.isInUse() ? new RemovedCarData(car, null) : actualCarRemoved(car);
	}

	private RemovedCarData actualCarRemoved(Car car) {
		String regNumber = car.getRegNumber();
		List<RentRecord> removedRecords = carRecords.getOrDefault(regNumber, new ArrayList<>());
		removedFromDriverRecords(removedRecords);
		removeFromRecords(removedRecords);
		cars.remove(regNumber);
		carRecords.remove(regNumber);
		return new RemovedCarData(car, removedRecords);
	}

	private void removedFromDriverRecords(List<RentRecord> removedRecords) {
		removedRecords.forEach(r -> driverRecords.get(r.getLicenseId()).remove(r));
	}

	private void removeFromRecords(List<RentRecord> removedRecords) {
		removedRecords.forEach(r -> records.get(r.getRentDate()).remove(r));
	}

	@Override
	public List<RemovedCarData> removeModel(String modelName) {
		List<Car> carsModel = modelCars.getOrDefault(modelName, new ArrayList<>());
		return carsModel.stream().filter(c -> !c.isFlRemoved()).map(c -> removeCar(c.getRegNumber())).toList();
	}

	@Override
	public RemovedCarData returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages,
			int tankPersent) {
		RentRecord record = driverRecords.get(licenseId).stream()
				.filter(rr -> rr.getRegNumber().equals(regNumber) && rr.getReturnDate() == null).findFirst()
				.orElse(null);
		if (record == null)
			return null;
		updateRecord(record, returnDate, damages, tankPersent);
		Car car = getCar(regNumber);
		updateCar(car, damages);
		return car.isFlRemoved() || damages > REMOVE_THRESHOLD ? actualCarRemoved(car) : new RemovedCarData(car, null);
	}

	private void updateRecord(RentRecord record, LocalDate returnDate, int damages, int tankPercent) {
		record.setDamages(damages);
		record.setReturnDate(returnDate);
		record.setTankPercent(tankPercent);
		double cost = computeCost(getRentPrice(record.getRegNumber()), record.getRentDays(), getDelay(record),
				tankPercent, getTankVolume(record.getRegNumber()));
		record.setCost(cost);
	}

	private double computeCost(int rentPrice, int rentDays, int delay, int tankPercent, int tankVolume) {
		double cost = rentPrice * rentDays;
		if (delay > 0)
			cost += delay * (rentPrice * (1 + finePercent / 100.));
		if (tankPercent < 100)
			cost += tankVolume * ((100 - tankPercent) / 100.) * gasPrice;
		return cost;
	}

	private int getRentPrice(String regNumber) {
		String modelName = cars.get(regNumber).getModelName();
		return models.get(modelName).getPriceDay();
	}

	private int getDelay(RentRecord record) {
		long realDays = ChronoUnit.DAYS.between(record.getRentDate(), record.getReturnDate());
		int delta = (int) (realDays - record.getRentDays());
		return delta < 0 ? 0 : delta;
	}

	private int getTankVolume(String regNumber) {
		String modelName = cars.get(regNumber).getModelName();
		return models.get(modelName).getGasTank();
	}

	private void updateCar(Car car, int damages) {
		car.setInUse(false);
		if (damages >= BAD_THRESHOLD)
			car.setState(State.BAD);
		else if (damages >= GOOD_THRESHOLD)
			car.setState(State.GOOD);
	}

}
