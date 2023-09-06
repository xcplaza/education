package telran.cars.model;
import static telran.cars.api.ApiConstants.*;
import java.time.LocalDate;
import java.util.List;

import telran.cars.dto.Car;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.dto.RemovedCarData;
import telran.cars.dto.RentCarData;
import telran.cars.dto.RentRecord;
import telran.cars.dto.ReturnCarData;
import telran.cars.dto.StatisticsData;
import telran.net.TcpClientJava;

@SuppressWarnings("serial")
public class RentCompanyProxy extends TcpClientJava implements IRentCompany {
	
	

	public RentCompanyProxy(String hostname, int port) throws Exception {
		super(hostname, port);
	}

	@Override
	public int getGasPrice() {
		// TODO Auto-generated method stub
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
	public void setFinePercent(int finePercent) {
		// TODO Auto-generated method stub

	}

	@Override
	public CarsReturnCode addCar(Car car) {		
		return sendRequestGetResponse(ADD_CAR, car);
	}

	@Override
	public CarsReturnCode addDriver(Driver driver) {
		return sendRequestGetResponse(ADD_DRIVER, driver);
	}

	@Override
	public CarsReturnCode addModel(Model model) {
		
		return sendRequestGetResponse(ADD_MODEL, model);
	}

	@Override
	public Car getCar(String regNumber) {
		
		return sendRequestGetResponse(GET_CAR, regNumber);
	}

	@Override
	public Model getModel(String modelName) {
		
		return sendRequestGetResponse(GET_MODEL, modelName);
	}

	@Override
	public Driver getDriver(long licenseId) {
		
		return sendRequestGetResponse(GET_DRIVER, licenseId);
	}

	@Override
	public CarsReturnCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays) {
		
		return sendRequestGetResponse(RENT_CAR, 
				new RentCarData(regNumber, licenseId, rentDate, rentDays));
	}

	@Override
	public List<Car> getCarsByDriver(long licenseId) {
		
		return sendRequestGetResponse(GET_DRIVER_CARS, licenseId);
	}

	@Override
	public List<Driver> getDriversByCar(String regNumber) {
		
		return sendRequestGetResponse(GET_CAR_DRIVERS, regNumber);
	}

	@Override
	public List<Car> getCarsByModel(String modelName) {
		
		return sendRequestGetResponse(GET_MODEL_CARS, modelName);
	}

	@Override
	public List<RentRecord> getRentRecordsAtDates(LocalDate fromDate, LocalDate toDate) {
		
		return sendRequestGetResponse(GET_RECORDS, 
				new StatisticsData(fromDate, toDate, 0, 0));
	}

	@Override
	public RemovedCarData removeCar(String regNumber) {
		
		return sendRequestGetResponse(REMOVE_CAR, regNumber);
	}

	@Override
	public List<RemovedCarData> removeCarsOfModel(String modelName) {
		return sendRequestGetResponse(REMOVE_MODEL, modelName);
	}

	@Override
	public RemovedCarData returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages,
			int tankPercent) {
		return sendRequestGetResponse(RETURN_CAR, 
				new ReturnCarData(regNumber, licenseId, returnDate, damages, tankPercent));
	}

	@Override
	public List<String> getMostPopularCarModels(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge) {
		
		return sendRequestGetResponse(GET_MOST_POPULAR_MODELS, 
				new StatisticsData(fromDate, toDate, fromAge, toAge));
	}

	@Override
	public List<String> getMostProfitableCarModels(LocalDate fromDate, LocalDate toDate) {
		return sendRequestGetResponse(GET_MOST_PROFITABLE_MODELS, new StatisticsData(fromDate, toDate, 0, 0));
	}

	@Override
	public List<Driver> getMostActiveDriver() {
		return sendRequestGetResponse(GET_MOST_ACTIVE_DRIVERS, null);
	}

	@Override
	public List<String> getModelNames() {
		return sendRequestGetResponse(GET_CAR_MODELS, null);
	}

}
