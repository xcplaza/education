package telran.cars.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import telran.cars.dto.*;
import telran.util.Persistable;
import static telran.cars.model.RentCompanyLocks.*;

@SuppressWarnings("serial")
public class RentCompanyEmbedded extends AbstractRentCompany implements Persistable {
	private static final int REMOVE_THRESHOLD = 60;
	private static final int GOOD_THRESHOLD = 10;
	private static final int BAD_THRESHOLD = 30;
//	Sprint1
	HashMap<String, Car> cars = new HashMap<>();
	HashMap<Long, Driver> drivers = new HashMap<>();
	HashMap<String, Model> models = new HashMap<>();
//	Sprint2
	TreeMap<LocalDate, List<RentRecord>> records = new TreeMap<>();
	HashMap<Long, List<RentRecord>> driverRecords = new HashMap<>();
	HashMap<String, List<RentRecord>> carRecords = new HashMap<>();
	HashMap<String, List<Car>> modelCars = new HashMap<>();

	@Override
	public CarsReturnCode addModel(Model model) {
		return models.putIfAbsent(model.getModelName(), model) == null ? CarsReturnCode.OK
				: CarsReturnCode.MODEL_EXISTS;
	}

	@Override
	public Model getModel(String modelName) {
		return models.get(modelName);
	}

	@Override
	public CarsReturnCode addCar(Car car) {
		LockUnlock_addCar(true);
		try {
			if (!models.containsKey(car.getModelName()))
				return CarsReturnCode.NO_MODEL;
			boolean res = cars.putIfAbsent(car.getRegNumber(), car) == null;
			if (!res)
				return CarsReturnCode.CAR_EXISTS;
			addModelCars(car);
			return CarsReturnCode.OK;
		} finally {
			LockUnlock_addCar(false);
		}
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
	public CarsReturnCode addDriver(Driver driver) {

		return drivers.putIfAbsent(driver.getLicenseId(), driver) == null ? CarsReturnCode.OK
				: CarsReturnCode.DRIVER_EXISTS;
	}

	@Override
	public Driver getDriver(long licenseId) {
		return drivers.get(licenseId);
	}

	@Override
	public void save(String fileName) {
		lockUnlock_save(true);
		try {
			try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName))) {
				output.writeObject(this);
			} catch (Exception e) {
				System.out.println("Error int method save " + e.getMessage());
			} 
		} finally {
			lockUnlock_save(false);
		}
	}

	public static IRentCompany restoreFromFile(String fileName) {
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
			return (IRentCompany) input.readObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new RentCompanyEmbedded();
		}
	}

	@Override
	public CarsReturnCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays) {
		lockUnlock_rentCar(true);
		try {
			Car car = getCar(regNumber);
			if (car == null)
				return CarsReturnCode.NO_CAR;
			if (car.isFlRemoved())
				return CarsReturnCode.CAR_REMOVED;
			if (car.isInUse())
				return CarsReturnCode.CAR_IN_USE;
			if (!drivers.containsKey(licenseId))
				return CarsReturnCode.NO_DRIVER;
			RentRecord record = new RentRecord(regNumber, licenseId, rentDate, rentDays);
			addToCarRecords(record);
			addToDriverRecords(record);
			addToRecords(record);
			car.setInUse(true);
			return CarsReturnCode.OK;
		} finally {
			lockUnlock_rentCar(false);
		}
	}

	private void addToRecords(RentRecord record) {
		LocalDate rentDate = record.getRentDate();
		List<RentRecord> listRecords = records.getOrDefault(rentDate, new ArrayList<>());
		listRecords.add(record);
		records.putIfAbsent(rentDate, listRecords);
	}

	private void addToDriverRecords(RentRecord record) {
		long licenseId = record.getLicenseId();
		List<RentRecord> listRecords = driverRecords.getOrDefault(licenseId, new ArrayList<>());
		listRecords.add(record);
		driverRecords.putIfAbsent(licenseId, listRecords);
	}

	private void addToCarRecords(RentRecord record) {
		String regNumber = record.getRegNumber();
		List<RentRecord> listRecords = carRecords.getOrDefault(regNumber, new ArrayList<>());
		listRecords.add(record);
		carRecords.putIfAbsent(regNumber, listRecords);

	}

	@Override
	public List<Car> getDriverCars(long licenseId) {
		List<RentRecord> listRecords = driverRecords.getOrDefault(licenseId, new ArrayList<>());
		return listRecords.stream().map(r -> getCar(r.getRegNumber())).distinct().toList();
	}

	@Override
	public List<Driver> getCarDrivers(String regNumber) {
		List<RentRecord> listRecords = carRecords.getOrDefault(regNumber, new ArrayList<>());
		return listRecords.stream().map(r -> getDriver(r.getLicenseId())).distinct().toList();
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
		lockUnlock_removeCar(true);
		try {
			Car car = getCar(regNumber);
			if (car == null || car.isFlRemoved())
				return null;
			car.setFlRemoved(true);
			return car.isInUse() ? new RemovedCarData(car, null) : actualCarRemoved(car);
		} finally {
			lockUnlock_removeCar(false);
		}
	}

	private RemovedCarData actualCarRemoved(Car car) {
		String regNumber = car.getRegNumber();
		List<RentRecord> removedRecords = carRecords.getOrDefault(regNumber, new ArrayList<>());
		removedFromDriverRecords(removedRecords);
		removeFromRecords(removedRecords);
		cars.remove(regNumber);
		carRecords.remove(regNumber);
		List<Car> mCars = modelCars.get(car.getModelName());
		mCars.remove(car);
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
			int tankPercent) {
		RentRecord record = driverRecords.get(licenseId).stream()
				.filter(rr -> rr.getRegNumber().equals(regNumber) && rr.getReturnDate() == null).findFirst()
				.orElse(null);
		if (record == null)
			return null;
		updateRecord(record, returnDate, damages, tankPercent);
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

	@Override
	public List<String> getMostPopularCarModels(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge) {
		List<RentRecord> rRecords = getRentRecordsAtDates(fromDate, toDate);
		Map<String, Long> mapOccurances = rRecords.stream().filter(r -> isProperAge(r, fromAge, toAge))
				.collect(Collectors.groupingBy(r -> getCar(r.getRegNumber()).getModelName(), Collectors.counting()));
		long maxOccurrances = Collections.max(mapOccurances.values());
		List<String> res = new ArrayList<>();
		mapOccurances.forEach((k, v) -> {
			if (v == maxOccurrances)
				res.add(k);
		});

		return res;
	}

	private boolean isProperAge(RentRecord r, int fromAge, int toAge) {
		LocalDate rentDate = r.getRentDate();
		Driver driver = getDriver(r.getLicenseId());
		int driverAge = rentDate.getYear() - driver.getBirthYear();
		return driverAge >= fromAge && driverAge < toAge;
	}

	@Override
	public List<String> getMostProfitableCarModels(LocalDate fromDate, LocalDate toDate) {
		List<RentRecord> rRecords = getRentRecordsAtDates(fromDate, toDate);
		Map<String, Double> modelCost = rRecords.stream().collect(Collectors.groupingBy(
				r -> getCar(r.getRegNumber()).getModelName(), Collectors.summingDouble(RentRecord::getCost)));
		if (modelCost.isEmpty())
			return new ArrayList<>();
		double max = modelCost.values().stream().mapToDouble(x -> x).max().getAsDouble();
		List<String> res = new ArrayList<>();
		modelCost.forEach((k, v) -> {
			if (v == max)
				res.add(k);
		});
		return res;
	}

	@Override
	public List<Driver> getMostActiveDriver() {
		long max = driverRecords.values().stream().mapToLong(x -> x.size()).max().getAsLong();
		List<Driver> res = new ArrayList<>();
		driverRecords.forEach((k, v) -> {
			if (v.size() == max)
				res.add(getDriver(k));
		});
		return res;
	}

	public List<String> getModelNames() {
		return new ArrayList<>(models.keySet());
	}

	public List<Long> getLicenseDriver() {
		return new ArrayList<>(drivers.keySet());
	}

}
