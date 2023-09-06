package telran.cars.model;

import java.io.Serializable;
import java.util.List;

import static telran.cars.api.ApiConstants.*;

import telran.cars.dto.*;

import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TcpResponseCode;
import telran.net.server.ProtocolJava;

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

		switch (type) {
		case ADD_CAR:
			return _car_add(data);
		case ADD_MODEL:
			return _model_add(data);
		case RENT_CAR:
			return _car_rent(data);
		case GET_MOST_POPULAR_MODELS:
			return _models_popular(data);
		case GET_MOST_ACTIVE_DRIVERS:
			return _drivers_active(data);
		case ADD_DRIVER:
			return _driver_add(data);
		case GET_MODEL:
			return _model(data);
		case GET_DRIVER_CARS:
			return _driver_cars(data);	
		case GET_CAR_MODELS:
			return _models(data);
		case GET_MODEL_CARS:
			return _model(data);
		case RETURN_CAR:
			return _car_return(data);
		case GET_CAR_DRIVERS:
			return _drivers_car(data);
		case GET_CAR:
			return _car(data);
		case GET_DRIVER:
			return _driver(data);
		case REMOVE_CAR:
			return _car_remove(data);	
		case REMOVE_MODEL:
			return _model_remove(data);	
		case GET_MOST_PROFITABLE_MODELS:
			return _models_profitable(data);	
		case GET_RECORDS:
			return _records(data);	
		default:
			return new ResponseJava(TcpResponseCode.UNKNOWN, null);
		}
		
	}

	private ResponseJava _drivers_active(Serializable reqData)
	{
		try
		{
			List<Driver> res = service.getMostActiveDriver();
			return new ResponseJava(TcpResponseCode.OK, (Serializable) res);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}
	}

	private ResponseJava _models_popular(Serializable reqData)
	{
		try
		{
			StatisticsData data = (StatisticsData) reqData;
			List<String> res = service.getMostPopularCarModels(data.getFromDate(), 
					data.getToDate(), data.getFromAge(), data.getToAge());
			return new ResponseJava(TcpResponseCode.OK, (Serializable) res);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}
	}

	private ResponseJava _car_add(Serializable reqData)
	{

		try
		{
			Car car = (Car) reqData;
			return new ResponseJava(TcpResponseCode.OK, service.addCar(car));
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}
	}

	private ResponseJava wrongRequest(String message)
	{
		return new ResponseJava(TcpResponseCode.WRONG_REQUEST, message);
	}

	public ResponseJava _model(Serializable data)
	{
		try
		{
			String modelName = (String) data;
			Serializable responseData = (Serializable) service.getCarsByModel(modelName);
			return new ResponseJava(TcpResponseCode.OK, responseData);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}
	}

	public ResponseJava _driver_add(Serializable data)
	{
		try
		{
			Driver driver = (Driver) data;
			Serializable responseData = (Serializable) service.addDriver(driver);
			return new ResponseJava(TcpResponseCode.OK, responseData);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}
	}

	public ResponseJava _driver_cars(Serializable data)
	{
		try
		{
			Long licenseId = (Long) data;
			Serializable responseData = (Serializable) service.getCarsByDriver(licenseId);
			return new ResponseJava(TcpResponseCode.OK, responseData);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}
	}

	public ResponseJava _model_cars(Serializable data)
	{
		try
		{
			String modelName = (String) data;
			Serializable responseData = (Serializable) service.getCarsByModel(modelName);
			return new ResponseJava(TcpResponseCode.OK, responseData);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}
	}

	public ResponseJava _car_rent(Serializable data)
	{
		try
		{
			RentCarData rcdata = (RentCarData) data;
			Serializable responseData = (Serializable) service.rentCar(rcdata.getRegNumber(), 
					rcdata.getLicenseId(), rcdata.getRentDate(), rcdata.getRentDays());
			return new ResponseJava(TcpResponseCode.OK, responseData);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}
	}

	public ResponseJava _drivers_car(Serializable data)
	{
		try
		{
			String regNumber = (String) data;
			Serializable responseData = (Serializable) service.getDriversByCar(regNumber);
			return new ResponseJava(TcpResponseCode.OK, responseData);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}
	}

	public ResponseJava _driver(Serializable data)
	{
		try
		{
			Long licenseId = (Long) data;
			Serializable responseData = (Serializable) service.getDriver(licenseId);
			return new ResponseJava(TcpResponseCode.OK, responseData);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}
	}

	public ResponseJava _car_return(Serializable data)
	{
		try
		{
			ReturnCarData rcdata = (ReturnCarData) data;
			Serializable responseData = (Serializable) service.returnCar(rcdata.getRegNumber(),
					rcdata.getLicenseId(),
					rcdata.getReturnDate(), rcdata.getDamages(), rcdata.getTankPercent());
			return new ResponseJava(TcpResponseCode.OK, responseData);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}
	}

	public ResponseJava _car(Serializable data)
	{
		try
		{
			String carNumber = (String) data;
			Serializable responseData = (Serializable) service.getCar(carNumber);
			return new ResponseJava(TcpResponseCode.OK, responseData);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}
	}

	public ResponseJava _car_remove(Serializable data)
	{
		try
		{
			String carNumber = (String) data;
			Serializable responseData = (Serializable) service.removeCar(carNumber);
			return new ResponseJava(TcpResponseCode.OK, responseData);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}
	}

	public ResponseJava _model_remove(Serializable data)
	{
		try
		{
			String modelName = (String) data;
			Serializable responseData = (Serializable) service.removeCarsOfModel(modelName);
			return new ResponseJava(TcpResponseCode.OK, responseData);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}
	}

	public ResponseJava _models_profitable(Serializable data)
	{
		try
		{
			StatisticsData sdata = (StatisticsData) data;
			Serializable responseData = (Serializable) 
					service.getMostProfitableCarModels(sdata.getFromDate(), sdata.getToDate());
			return new ResponseJava(TcpResponseCode.OK, responseData);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}
	}

	public ResponseJava _model_add(Serializable data)
	{
		try
		{
			Model model = (Model) data;
			Serializable responseData = service.addModel(model);
			return new ResponseJava(TcpResponseCode.OK, responseData);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}

	}

	public ResponseJava _records(Serializable data)
	{
		try
		{
			StatisticsData sdata = (StatisticsData) data;
			Serializable responseData = (Serializable) 
					service.getRentRecordsAtDates(sdata.getFromDate(), sdata.getToDate());
			return new ResponseJava(TcpResponseCode.OK, responseData);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}

	}

	public ResponseJava _models(Serializable data)
	{
		try
		{
			Serializable responseData = (Serializable) service.getModelNames();
			return new ResponseJava(TcpResponseCode.OK, responseData);
		} catch (Exception e)
		{
			return wrongRequest(e.getMessage());
		}

	}

}
