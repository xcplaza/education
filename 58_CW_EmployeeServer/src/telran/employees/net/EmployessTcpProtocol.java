package telran.employees.net;

import java.io.Serializable;

import telran.employees.dto.Employee;
import telran.employees.service.IEMployees;
import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TCPResponseCode;
import telran.server.ProtocolJava;

public class EmployessTcpProtocol implements ProtocolJava {
	IEMployees service;

	public EmployessTcpProtocol(IEMployees service) {
		super();
		this.service = service;
	}

	@Override
	public ResponseJava getResponse(RequestJava request) {
		switch (request.requestType) {
		case "hireEmployee":
			return hireEmployess(request.requestData);
		case "fireEmployee":
			return fireEmployee(request.requestData);
// next case
		default:
			break;
		}
		return null;
	}

	private ResponseJava fireEmployee(Serializable requestData) {
		// TODO Auto-generated method stub
		return null;
	}

	private ResponseJava hireEmployess(Serializable requestData) {
		try {
			Employee emp = (Employee) requestData;
			boolean res = service.hireEmployee(emp);
			return new ResponseJava(TCPResponseCode.OK, res);
		} catch (Exception e) {
			return wrongRequest(e);
		}
	}

	private ResponseJava wrongRequest(Exception e) {
		return new ResponseJava(TCPResponseCode.WRONG_REQUEST, e.getMessage());
	}

}
