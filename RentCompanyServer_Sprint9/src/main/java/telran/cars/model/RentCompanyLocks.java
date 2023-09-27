package telran.cars.model;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RentCompanyLocks {
	static final ReadWriteLock carsLock = new ReentrantReadWriteLock();
	static final ReadWriteLock driversLock = new ReentrantReadWriteLock();
	static final ReadWriteLock modelsLock = new ReentrantReadWriteLock();
	static final ReadWriteLock recordsLock = new ReentrantReadWriteLock();

	static final int CARS_INDEX = 0;
	static final int DRIVERS_INDEX = 1;
	static final int MODELS_INDEX = 2;
	static final int RECORDS_INDEX = 3;

	static final int WRITE_INDEX = 0;
	static final int READ_INDEX = 1;

	static Lock[][] locks;
	static {
		locks = new Lock[2][4];
		ReadWriteLock[] rwl = { carsLock, driversLock, modelsLock, recordsLock };
		for (int i = 0; i < rwl.length; i++) {
			locks[WRITE_INDEX][i] = rwl[i].writeLock();
			locks[READ_INDEX][i] = rwl[i].readLock();
		}
	}

	private static void lockUnlock(boolean flag, int typeLock, int... indexes) {
		if (flag)
			lock(typeLock, indexes);
		else
			unlock(typeLock, indexes);
	}

	private static void unlock(int typeLock, int[] indexes) {
		Arrays.sort(indexes);
		for (int index : indexes) {
			locks[typeLock][index].unlock();
		}
	}

	private static void lock(int typeLock, int[] indexes) {
		Arrays.sort(indexes);
		for (int index : indexes) {
			locks[typeLock][index].lock();
		}
	}

	public static void lockUnlock_addCar(boolean flag) {
		lockUnlock(flag, WRITE_INDEX, CARS_INDEX);
		lockUnlock(flag, READ_INDEX, MODELS_INDEX);

	}

//	@Override
//	public CarsReturnCode addDriver(Driver driver) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public CarsReturnCode addModel(Model model) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Car getCar(String regNumber) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Model getModel(String modelName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Driver getDriver(long licenseId) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	public static void lockUnlock_rentCar(boolean flag) {
		lockUnlock(flag, READ_INDEX, DRIVERS_INDEX);
		lockUnlock(flag, WRITE_INDEX, CARS_INDEX, RECORDS_INDEX);
	}

//	@Override
//	public List<Car> getCarsByDriver(long licenseId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Driver> getDriversByCar(String regNumber) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Car> getCarsByModel(String modelName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<RentRecord> getRentRecordsAtDates(LocalDate fromDate, LocalDate toDate) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	public static void lockUnlock_removeCar(boolean flag) {
		lockUnlock(flag, WRITE_INDEX, CARS_INDEX, RECORDS_INDEX);
	}

//	@Override
//	public List<RemovedCarData> removeCarsOfModel(String modelName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public RemovedCarData returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages,
//			int tankPercent) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<String> getMostPopularCarModels(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<String> getMostProfitableCarModels(LocalDate fromDate, LocalDate toDate) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Driver> getMostActiveDriver() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<String> getModelNames() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public static void lockUnlock_save(boolean flag) {
		lockUnlock(flag, READ_INDEX, 0, 1, 2, 3);
	}

}
