package telran.employees.net;

import java.io.Serializable;

import telran.employees.dto.Employee;
import telran.employees.service.IEmployees;
import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TCPResponseCode;
import telran.server.ProtocolJava;


public class EmployeesTcpProtocol implements ProtocolJava {
	
	IEmployees service;

	public EmployeesTcpProtocol(IEmployees service) {
		super();
		this.service = service;
	}

	@Override
	public ResponseJava getResponse(RequestJava request) {
		switch (request.requestType) {
		case "hireEmployee": return hireEmployee(request.requestData);
			

		default:
			break;
		}
		return null;
	}

	private ResponseJava hireEmployee(Serializable requestData) {
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
