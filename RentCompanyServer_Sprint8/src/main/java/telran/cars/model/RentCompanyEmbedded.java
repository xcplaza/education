package telran.cars.model;

import static telran.cars.model.RentCompanyLocks.lockUnlock_addCar;
import static telran.cars.model.RentCompanyLocks.lockUnlock_removeCar;
import static telran.cars.model.RentCompanyLocks.lockUnlock_rentCar;
import static telran.cars.model.RentCompanyLocks.lockUnlock_save;

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

import telran.cars.dto.Car;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.dto.RemovedCarData;
import telran.cars.dto.RentRecord;
import telran.cars.dto.State;
import telran.cars.utils.Persistable;

@SuppressWarnings("serial")
public class RentCompanyEmbedded extends AbstractRentCompany implements Persistable
{
	private static final int REMOVE_THRESHOLD = 60;
	private static final int BAD_THRESHOLD = 30;
	private static final int GOOD_THRESHOLD = 10;
	
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
	public CarsReturnCode addCar(Car car)
	{
		lockUnlock_addCar(true);
		try {
			if (!models.containsKey(car.getModelName()))
				return CarsReturnCode.NO_MODEL;
			boolean res = cars.putIfAbsent(car.getRegNumber(), car) == null;
			if (!res)
				return CarsReturnCode.CAR_EXISTS;
			addToModelCars(car);
			return CarsReturnCode.OK;
		} finally {
			lockUnlock_addCar(false);
		}
	}

	private void addToModelCars(Car car)
	{
		String modelName = car.getModelName();
		List<Car> list = modelCars.getOrDefault(modelName, new ArrayList<>());
		list.add(car);
		modelCars.putIfAbsent(modelName, list);
	}

	@Override
	public CarsReturnCode addDriver(Driver driver)
	{
		return drivers.putIfAbsent(driver.getLicenseId(), driver) == null ? CarsReturnCode.OK
				: CarsReturnCode.DRIVER_EXISTS;
	}

	@Override
	public CarsReturnCode addModel(Model model)
	{
		return models.putIfAbsent(model.getModelName(), model) == null ? CarsReturnCode.OK
				: CarsReturnCode.MODEL_EXISTS;
	}

	@Override
	public Car getCar(String regNumber)
	{
		return cars.get(regNumber);
	}

	@Override
	public Model getModel(String modelName)
	{
		return models.get(modelName);
	}

	@Override
	public Driver getDriver(long licenseId)
	{
		return drivers.get(licenseId);
	}

	@Override
	public void save(String fileName)
	{
		lockUnlock_save(true);
		try {
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
				out.writeObject(this);
			} catch (Exception e) {
				System.out.println("Error in method save " + e.getMessage());
			} 
		} finally {
			lockUnlock_save(false);
		}
	}

	public static RentCompanyEmbedded restoreFromFile(String fileName)
	{
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName)))
		{
			return (RentCompanyEmbedded) in.readObject();
		} catch (Exception e)
		{
			return new RentCompanyEmbedded();
		}
	}

	@Override
	public CarsReturnCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays)
	{
		lockUnlock_rentCar(true);
		try {
			Car car = getCar(regNumber);
			if (car == null)
				return CarsReturnCode.NO_CAR;
			if (car.isFlRemoved())
				return CarsReturnCode.CAR_REMOVED;
			if (car.isUse())
				return CarsReturnCode.CAR_IN_USE;
			if (!drivers.containsKey(licenseId))
				return CarsReturnCode.NO_DRIVER;
			RentRecord record = new RentRecord(regNumber, licenseId, rentDate, rentDays);
			addToCarRecords(record);
			addToDriverRecords(record);
			addToRecords(record);
			car.setUse(true);
			return CarsReturnCode.OK;
		} finally {
			lockUnlock_rentCar(false);
		}
	}

	private void addToRecords(RentRecord record)
	{
		LocalDate date = record.getRentDate();
		List<RentRecord> list = records.getOrDefault(date, new ArrayList<>());
		list.add(record);
		records.putIfAbsent(date, list);
	}

	private void addToDriverRecords(RentRecord record)
	{
		long licenseId = record.getLicenseId();
		List<RentRecord> list = driverRecords.getOrDefault(licenseId, new ArrayList<>());
		list.add(record);
		driverRecords.putIfAbsent(licenseId, list);
	}

	private void addToCarRecords(RentRecord record)
	{
		String regNumber = record.getRegNumber();
		List<RentRecord> list = carRecords.getOrDefault(regNumber, new ArrayList<>());
		list.add(record);
		carRecords.putIfAbsent(regNumber, list);
	}

	@Override
	public List<Car> getCarsByDriver(long licenseId)
	{
		List<RentRecord> list = driverRecords.getOrDefault(licenseId, new ArrayList<>());
		return list.stream().map(rr -> getCar(rr.getRegNumber())).distinct().toList();
	}

	@Override
	public List<Driver> getDriversByCar(String regNumber)
	{
		List<RentRecord> list = carRecords.getOrDefault(regNumber, new ArrayList<>());
//		{rr1{li, rn, rd}, rr2{li, rn, rd}, rr3{li, rn, rd}, rr4{li, rn, rd}} -> {driver1, driver2, driver3}
		List<Driver> res = list.stream().map(rr -> getDriver(rr.getLicenseId())).distinct().toList();
//		rr = rr1{li, rn, rd} -> driver1
		return res;
	}

	@Override
	public List<Car> getCarsByModel(String modelName)
	{
		List<Car> list = modelCars.getOrDefault(modelName, new ArrayList<>());
		return list.stream().filter(c -> !c.isFlRemoved() && !c.isUse()).toList();
	}

	@Override
	public List<RentRecord> getRentRecordsAtDates(LocalDate fromDate, LocalDate toDate)
	{
		Collection<List<RentRecord>> col = records.subMap(fromDate, toDate).values();
		return col.stream().flatMap(l -> l.stream()).toList();
	}

	@Override
	public RemovedCarData removeCar(String regNumber)
	{
		lockUnlock_removeCar(true);
		try {
			Car car = getCar(regNumber);
			if (car == null)
				return null;
			car.setFlRemoved(true);
			return car.isUse() ? new RemovedCarData(car, null) : actualCarRemove(car);
		} finally {
			lockUnlock_removeCar(false);
		}
	}

	private RemovedCarData actualCarRemove(Car car)
	{
		String regNumber = car.getRegNumber();
		List<RentRecord> list = carRecords.get(regNumber);
		cars.remove(regNumber);
		carRecords.remove(regNumber);
		removeFromDriverRecords(list);
		removeFromRecords(list);
		removeFromModelCars(car);
		return new RemovedCarData(car, list);
	}

	private void removeFromModelCars(Car car)
	{
		modelCars.get(car.getModelName()).remove(car);
	}

	private void removeFromRecords(List<RentRecord> list)
	{
		list.forEach(rr -> records.get(rr.getRentDate()).remove(rr));
	}

	private void removeFromDriverRecords(List<RentRecord> list)
	{
		list.forEach(rr -> driverRecords.get(rr.getLicenseId()).remove(rr));
	}

	@Override
	public List<RemovedCarData> removeCarsOfModel(String modelName)
	{
		List<Car> list = modelCars.get(modelName);
		if (list != null)
		{
			return list.stream().map(c -> removeCar(c.getRegNumber())).toList();
		}
		return new ArrayList<>();
	}

	@Override
	public RemovedCarData returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages,
			int tankPercent)
	{
		RentRecord record = driverRecords.get(licenseId).stream()
				.filter(rr -> rr.getRegNumber().equals(regNumber) && rr.getReturnDate() == null).findFirst()
				.orElse(null);
		if (record == null)
			return null;
		updateRecord(record, returnDate, damages, tankPercent);
		Car car = getCar(regNumber);
		updateCar(car, damages);
		return car.isFlRemoved() || damages > REMOVE_THRESHOLD ? actualCarRemove(car) : new RemovedCarData(car, null);
	}

	private void updateCar(Car car, int damages)
	{
		car.setUse(false);
		if(damages >= BAD_THRESHOLD)
			car.setState(State.BAD);
		else if(damages >= GOOD_THRESHOLD)
			car.setState(State.GOOD);
	}

	private void updateRecord(RentRecord record, LocalDate returnDate, int damages, int tankPercent)
	{
		record.setDamages(damages);
		record.setReturnDate(returnDate);
		record.setTankPercent(tankPercent);
		double cost = computeCost(getRentPrice(record.getRegNumber()), record.getRentDays(), getDelay(record), tankPercent,
				getTankVolume(record.getRegNumber()));
		record.setCost(cost);
	}
	
	private int getTankVolume(String regNumber)
	{
		String modelName = cars.get(regNumber).getModelName();
		return models.get(modelName).getGasTank();
	}

	private int getDelay(RentRecord record)
	{
		long realDays = ChronoUnit.DAYS.between(record.getRentDate(), record.getReturnDate());
		int delta = (int) (realDays - record.getRentDays());
		return delta < 0 ? 0 : delta;
	}

//	double cost = priceDay * rentDays + delay(delayDays * delayPercent) + costTank

	private int getRentPrice(String regNumber)
	{
		String modelName = cars.get(regNumber).getModelName();
		return models.get(modelName).getPriceDay();
	}

	@Override
	public List<String> getMostPopularCarModels(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge)
	{
		List<RentRecord> list = getRentRecordsAtDates(fromDate, toDate);
		Map<String, Long> map = list.stream().filter(rr -> isProperAge(rr, fromAge, toAge))
				.collect(Collectors.groupingBy(rr -> getCar(rr.getRegNumber()).getModelName(), //Map<modelName, List<RentRecord>>
						Collectors.counting()));//List<RentRecord>>.stream().count()
		long max = Collections.max(map.values());
		List<String> models = new ArrayList<>();
		map.forEach((k, v) ->
		{
			if(v == max)
				models.add(k);
		});
		return models;
	}

	private boolean isProperAge(RentRecord rr, int fromAge, int toAge)
	{
		LocalDate rentDate = rr.getRentDate();
		int birthYear= getDriver(rr.getLicenseId()).getBirthYear();
		int age = rentDate.getYear() - birthYear;
		return age >= fromAge && age < toAge;
	}

	@Override
	public List<String> getMostProfitableCarModels(LocalDate fromDate, LocalDate toDate)
	{
		List<RentRecord> list = getRentRecordsAtDates(fromDate, toDate);
		if(list.isEmpty())		
			return new ArrayList<String>();
		Map<String, Double> map = list.stream()
				.collect(Collectors.groupingBy(rr -> getCar(rr.getRegNumber()).getModelName(),
						Collectors.summingDouble(RentRecord::getCost)));
		double max = map.values().stream().mapToDouble(c -> c).max().getAsDouble();
		List<String> res = new ArrayList<>();
		map.forEach((k, v) ->
		{
			if(v == max)
				res.add(k);
		});
		return res;
	}

	@Override
	public List<Driver> getMostActiveDriver()
	{
		long max = driverRecords.values().stream().mapToLong(l -> l.size()).max().getAsLong();
		List<Driver> res = new ArrayList<>();
		driverRecords.forEach((k, v) ->
		{
			if(v.size() == max)
				res.add(getDriver(k));
		});
		return res;
	}

	@Override
	public List<String> getModelNames()
	{
		return new ArrayList<>(models.keySet());
	}

}
