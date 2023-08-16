package telran.cars.model;

import java.io.Serializable;
import java.util.List;

import telran.cars.dto.*;
import static telran.cars.api.ApiConstants.*;
import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TCPResponseCode;
import telran.server.ProtocolJava;

public class RentCompanyProtocol implements ProtocolJava {
	IRentCompany service;

	public RentCompanyProtocol(IRentCompany service) {
		super();
		this.service = service;
	}

	@Override
	public ResponseJava getResponse(RequestJava request) {
		String type = request.requestType;
		Serializable data = request.requestData;

		try {
			switch (type) {
			case ADD_CAR:
				return _car_add(data);
			case ADD_MODEL:
				return _model_add(data);
			case RENT_CAR:
				return _car_rent(data);
			case GET_MOST_POPULAR_MODELS:
				return _models_popular(data);
			case GET_MODEL:
				return _model_car(data);
			case GET_CAR:
				return _get_car(data);
			case ADD_DRIVER:
				return _add_driver(data);
			case GET_DRIVER:
				return _get_driver(data);
//			CarsReturnCode rentCar
			case RETURN_CAR:
				return _return_car(data);
			case GET_DRIVER_CARS:
				return _get_driver_cars(data);
			case GET_CAR_DRIVERS:
				return _get_car_drivers(data);
			case GET_MODEL_CARS:
				return _get_model_cars(data);
			case GET_RECORDS:
				return null;
			case REMOVE_CAR:
				return null;
			case REMOVE_MODEL:
				return null;
//			RemovedCarData
//		case RETURN_CAR:
//			return null;
			case GET_MOST_PROFITABLE_MODELS:
				return null;
			case GET_MOST_ACTIVE_DRIVERS:
				return null;
			case GET_CAR_MODELS:
				return null;
//			List<Long> getLicenseDriver
//		case GET_DRIVER:
//			return null;

			default:
				return new ResponseJava(TCPResponseCode.UNKNOWN, null);
			}
		} catch (Exception e) {
			return new ResponseJava(TCPResponseCode.WRONG_REQUEST, null);
		}
	}

	private ResponseJava _get_model_cars(Serializable data) {
		// TODO Auto-generated method stub
		return null;
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
