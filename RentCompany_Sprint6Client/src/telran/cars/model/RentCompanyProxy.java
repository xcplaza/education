package telran.cars.model;

import java.time.LocalDate;
import java.util.List;

import static telran.cars.api.ApiConstants.*;
import telran.cars.dto.Car;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.dto.RemovedCarData;
import telran.cars.dto.RentCarData;
import telran.cars.dto.RentRecord;
import telran.cars.dto.ReturnCarData;
import telran.cars.dto.StatisticsData;
import telran.net.TCPClientJava;

@SuppressWarnings("serial")
public class RentCompanyProxy extends TCPClientJava implements IRentCompany {

	public RentCompanyProxy(String hostname, int port) throws Exception {
		super(hostname, port);
	}

	@Override
	public int getGasPrice() {
		return 0;
	}

	@Override
	public void setGasPrice(int price) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getFinePercent() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFinePercent(int percent) {
		// TODO Auto-generated method stub
	}

	@Override
	public CarsReturnCode addModel(Model model) {
		return sendRequestGetResponse(ADD_MODEL, model);
	}

	@Override
	public Model getModel(String modelName) {
		return sendRequestGetResponse(GET_MODEL, modelName);
	}

	@Override
	public CarsReturnCode addCar(Car car) {
		return sendRequestGetResponse(ADD_CAR, car);
	}

	@Override
	public Car getCar(String regNumber) {
		return sendRequestGetResponse(GET_CAR, regNumber);
	}

	@Override
	public CarsReturnCode addDriver(Driver driver) {
		return sendRequestGetResponse(ADD_DRIVER, driver);
	}

	@Override
	public Driver getDriver(long licenseId) {
		return sendRequestGetResponse(GET_DRIVER, licenseId);
	}

	@Override
	public CarsReturnCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays) {
		return sendRequestGetResponse(RETURN_CAR, new RentCarData(regNumber, licenseId, rentDate, rentDays));
	}

	@Override
	public List<Car> getDriverCars(long licenseId) {
		return sendRequestGetResponse(GET_DRIVER_CARS, licenseId);
	}

	@Override
	public List<Driver> getCarDrivers(String regNumber) {
		return sendRequestGetResponse(GET_CAR_DRIVERS, regNumber);
	}

	@Override
	public List<Car> getModelCars(String modelName) {
		return sendRequestGetResponse(GET_MODEL_CARS, modelName);
	}

	@Override
	public List<RentRecord> getRentRecordsAtDates(LocalDate fromDate, LocalDate toDate) {
		LocalDate[] ld = { fromDate, toDate };
		return sendRequestGetResponse(GET_RECORDS, ld);
	}

	@Override
	public RemovedCarData removeCar(String regNumber) {
		return sendRequestGetResponse(REMOVE_CAR, regNumber);
	}

	@Override
	public List<RemovedCarData> removeModel(String modelName) {
		return sendRequestGetResponse(REMOVE_MODEL, modelName);
	}

	@Override
	public RemovedCarData returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages,
			int tankPercent) {
		return sendRequestGetResponse(RETURN_CAR, new ReturnCarData());
	}

	@Override
	public List<String> getMostPopularCarModels(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge) {
		return sendRequestGetResponse(GET_MOST_POPULAR_MODELS, new StatisticsData(fromDate, toDate, fromAge, toAge));
	}

	@Override
	public List<String> getMostProfitableCarModels(LocalDate fromDate, LocalDate toDate) {
		LocalDate[] ld = { fromDate, toDate };
		return sendRequestGetResponse(GET_MOST_PROFITABLE_MODELS, ld);
	}

	@Override
	public List<Driver> getMostActiveDriver() {
		return sendRequestGetResponse(GET_MOST_ACTIVE_DRIVERS, null);
	}

	@Override
	public List<String> getModelNames() {
		return sendRequestGetResponse(GET_CAR_MODELS, null);
	}

	@Override
	public List<Long> getLicenseDriver() {
		return sendRequestGetResponse(GET_DRIVER, null);
	}

}
