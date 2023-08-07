package telran.employee.net;

import java.io.Serializable;
import java.util.List;
import telran.employee.dto.CompanySalary;
import telran.employee.dto.Employee;
import telran.employee.service.IEmployees;
import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TCPResponseCode;
import telran.server.ProtocolJava;

public class EmployeesTcpProtocol implements ProtocolJava {
	IEmployees employees;

	public EmployeesTcpProtocol(IEmployees empoyees) {
		super();
		this.employees = empoyees;
	}

	@Override
	public ResponseJava getResponse(RequestJava request) {
		Serializable requestData = request.requestData;

		switch (request.requestType) {
		case "hireEmployee":
			return hireEmployee(requestData);
		case "fireEmployee":
			return fireEmployee(requestData);
		case "getEmployeeData":
			return getEmployeeData(requestData);
		case "getEmployeesData":
			return getEmployeesData(requestData);
		case "getAvgSalary":
			return getAvgSalary(requestData);
		case "getCompaniesAvgSalary":
			return getCompaniesAvgSalary(requestData);
		case "getCompaniesGreaterAvgSalary":
			return getCompaniesGreaterAvgSalary(requestData);
		default:
			return new ResponseJava(TCPResponseCode.UNKNOWN, null);
		}
	}

	private ResponseJava getCompaniesGreaterAvgSalary(Serializable requestData) {
		try {
			List<CompanySalary> res = employees.getCompaniesGreaterAvgSalary();
			return new ResponseJava(TCPResponseCode.OK, (Serializable) res);
		} catch (Exception e) {
			return wrongResponse(e.getMessage());
		}
	}

	private ResponseJava getCompaniesAvgSalary(Serializable requestData) {
		try {
			List<CompanySalary> res = employees.getCompaniesAvgSalary();
			return new ResponseJava(TCPResponseCode.OK, (Serializable) res);
		} catch (Exception e) {
			return wrongResponse(e.getMessage());
		}
	}

	private ResponseJava getAvgSalary(Serializable requestData) {
		try {
			Integer res = employees.getAvgSalary();
			return new ResponseJava(TCPResponseCode.OK, res);
		} catch (Exception e) {
			return wrongResponse(e.getMessage());
		}
	}

	private ResponseJava getEmployeesData(Serializable requestData) {
		try {
			Integer[] salaryRange = (Integer[]) requestData;
			List<Employee> res = employees.getEmployeesDataBySalary(salaryRange[0], salaryRange[1]);
			return new ResponseJava(TCPResponseCode.OK, (Serializable) res);
		} catch (Exception e) {
			return wrongResponse(e.getMessage());
		}
	}

	private ResponseJava getEmployeeData(Serializable requestData) {
		try {
			Integer id = (Integer) requestData;
			Employee res = employees.getEmployeeData(id);
			return new ResponseJava(TCPResponseCode.OK, res);
		} catch (Exception e) {
			return wrongResponse(e.getMessage());
		}
	}

	private ResponseJava fireEmployee(Serializable requestData) {
		try {
			Integer id = (Integer) requestData;
			boolean res = employees.fireEmployee(id);
			return new ResponseJava(TCPResponseCode.OK, res);
		} catch (Exception e) {
			return wrongResponse(e.getMessage());
		}
	}

	private ResponseJava hireEmployee(Serializable requestData) {
		try {
			Employee emp = (Employee) requestData;
			boolean res = employees.hireEmployee(emp);
			return new ResponseJava(TCPResponseCode.OK, res);
		} catch (Exception e) {
			return wrongResponse(e.getMessage());
		}
	}

	private ResponseJava wrongResponse(String message) {
		return new ResponseJava(TCPResponseCode.WRONG_REQUEST, message);
	}

}
