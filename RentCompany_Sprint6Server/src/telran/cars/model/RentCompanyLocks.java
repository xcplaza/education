package telran.cars.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import telran.cars.dto.Car;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.dto.RemovedCarData;
import telran.cars.dto.RentRecord;

public class RentCompanyLocks {
	static final ReadWriteLock carsLock = new ReentrantReadWriteLock();
	static final ReadWriteLock driversLock = new ReentrantReadWriteLock();
	static final ReadWriteLock modelsLock = new ReentrantReadWriteLock();
	static final ReadWriteLock recordsLock = new ReentrantReadWriteLock();

//	2x-мерный массив для lock
	/*
	 * 0 1 [cwl] [crl] [dwl] [drl] [mwl] [mrl] [rwl] [rrl]
	 */
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
		else {
			unlock(typeLock, indexes);
		}
	}

	private static void unlock(int typeLock, int[] indexes) {
		Arrays.sort(indexes);
		for (int i : indexes) {
			locks[typeLock][i].unlock();
		}
	}

	private static void lock(int typeLock, int[] indexes) {
		Arrays.sort(indexes);
		for (int i : indexes) {
			locks[typeLock][i].lock();
		}
	}

	public static void LockUnlock_addCar(boolean flag) {
		lockUnlock(flag, WRITE_INDEX, CARS_INDEX);
		lockUnlock(flag, READ_INDEX, MODELS_INDEX);

	}

	public static void LockUnlock_addModel(boolean flag) {
		lockUnlock(flag, WRITE_INDEX, CARS_INDEX, MODELS_INDEX, RECORDS_INDEX);
	}

	public static void LockUnlock_getModel(boolean flag) {
		// TODO Auto-generated method stub

	}

	public static void LockUnlock_getCar(boolean flag) {
		// TODO Auto-generated method stub

	}

	public static void LockUnlock_addDriver(boolean flag) {
		// TODO Auto-generated method stub

	}

	public static void getDriver(boolean flag) {
		// TODO Auto-generated method stub

	}

	public static void lockUnlock_rentCar(boolean flag) {
		lockUnlock(flag, READ_INDEX, DRIVERS_INDEX);
		lockUnlock(flag, WRITE_INDEX, CARS_INDEX, RECORDS_INDEX);
	}

	public static void lockUnlock_getDriverCars(boolean flag) {
		// TODO Auto-generated method stub
	}

	public static void lockUnlock_getCarDrivers(boolean flag) {
		// TODO Auto-generated method stub
	}

	public static void lockUnlock_getModelCars(boolean flag) {
		// TODO Auto-generated method stub
	}

	public static void lockUnlock_getRentRecordsAtDates(boolean flag) {
		// TODO Auto-generated method stub
	}

	public static void lockUnlock_removeCar(boolean flag) {
		lockUnlock(flag, WRITE_INDEX, CARS_INDEX, RECORDS_INDEX);
	}

	public static void lockUnlock_removeModel(boolean flag) {
		// TODO Auto-generated method stub
	}

	public static void lockUnlock_returnCar(boolean flag) {
		// TODO Auto-generated method stub
	}

	public static void lockUnlock_getMostPopularCarModels(boolean flag) {
		// TODO Auto-generated method stub
	}

	public static void lockUnlock_getMostProfitableCarModels(boolean flag) {
		// TODO Auto-generated method stub
	}

	public static void lockUnlock_getMostActiveDriver(boolean flag) {
		// TODO Auto-generated method stub
	}

	public static void lockUnlock_getModelNames(boolean flag) {
		// TODO Auto-generated method stub
	}

	public static void lockUnlock_getLicenseDriver(boolean flag) {
		// TODO Auto-generated method stub
	}

	public static void lockUnlock_save(boolean flag) {
		lockUnlock(flag, READ_INDEX, 0, 1, 2, 3);
	}
}