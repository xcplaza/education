package telran.cars.model;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

import telran.cars.api.ApiConstants;
import telran.cars.dto.*;
import static telran.cars.api.ApiConstants.*;
import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TCPResponseCode;
import telran.server.ProtocolJava;

@SuppressWarnings("unused")
public class RentCompanyProtocol implements ProtocolJava {
	IRentCompany service;

	public RentCompanyProtocol(IRentCompany service) {
		super();
		this.service = service;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseJava getResponse(RequestJava request) {
		String type = request.requestType;
		Serializable data = request.requestData;

		try {
			Class clazz = RentCompanyProtocol.class;
			String typeS = type.replaceAll("_", "/");
			Method m = clazz.getDeclaredMethod(typeS, Serializable.class);
			return (ResponseJava) m.invoke(this, data);
		} catch (Exception e) {
			return new ResponseJava(TCPResponseCode.WRONG_REQUEST, null);
		}
	}

	private ResponseJava _remove_model(Serializable data) {
		String model = (String) data;
		List<RemovedCarData> res = service.removeModel(model);
		return new ResponseJava(TCPResponseCode.OK, (Serializable) res);
	}

	private ResponseJava _remove_car(Serializable data) {
		String regNumber = (String) data;
		RemovedCarData res = service.removeCar(regNumber);
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _get_records(Serializable data) {
		StatisticsData sd = (StatisticsData) data;
		List<RentRecord> res = service.getRentRecordsAtDates(sd.getFromDate(), sd.getToDate());
		return new ResponseJava(TCPResponseCode.OK, (Serializable) res);
	}

	private ResponseJava _get_model_cars(Serializable data) {
		String modelName = (String) data;
		List<Car> res = service.getModelCars(modelName);
		return new ResponseJava(TCPResponseCode.OK, (Serializable) res);
	}

	private ResponseJava _get_car_drivers(Serializable data) {
		String regNumber = (String) data;
		List<Driver> res = service.getCarDrivers(regNumber);
		return new ResponseJava(TCPResponseCode.OK, (Serializable) res);
	}

	private ResponseJava _get_driver_cars(Serializable data) {
		Long license = (Long) data;
		List<Car> res = service.getDriverCars(license);
		return new ResponseJava(TCPResponseCode.OK, (Serializable) res);
	}

	private ResponseJava _get_driver(Serializable data) {
		Long license = (Long) data;
		Driver res = service.getDriver(license);
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _return_car(Serializable data) {
		ReturnCarData rcd = (ReturnCarData) data;
		RemovedCarData res = service.returnCar(rcd.getRegNumber(), rcd.getLicenseId(), rcd.getReturnDate(),
				rcd.getDamages(), rcd.getTankPercent());
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _add_driver(Serializable data) {
		Driver driver = (Driver) data;
		CarsReturnCode res = service.addDriver(driver);
		service.addDriver(driver);
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _get_car(Serializable data) {
		String regNumber = (String) data;
		Car car = service.getCar(regNumber);
		return new ResponseJava(TCPResponseCode.OK, (Serializable) car);
	}

	private ResponseJava _model_car(Serializable data) {
		String model = (String) data;
		Model res = service.getModel(model);
		return new ResponseJava(TCPResponseCode.OK, (Serializable) res);
	}

	private ResponseJava _models_popular(Serializable data) {
		StatisticsData sd = (StatisticsData) data;
		List<String> res = service.getMostPopularCarModels(sd.getFromDate(), sd.getFromDate(), sd.getFromAge(),
				sd.getFromAge());
		return new ResponseJava(TCPResponseCode.OK, (Serializable) res);
	}

	private ResponseJava _car_rent(Serializable data) {
		RentCarData rcd = (RentCarData) data;
		CarsReturnCode res = service.rentCar(rcd.getRegNumber(), rcd.getLicenseId(), rcd.getRentDate(),
				rcd.getRentDays());
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _model_add(Serializable data) {
		Model model = (Model) data;
		service.addModel(model);
		CarsReturnCode res = service.addModel(model);
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _car_add(Serializable data) {
		Car car = (Car) data;
		CarsReturnCode res = service.addCar(car);
		return new ResponseJava(TCPResponseCode.OK, res);
	}

}
