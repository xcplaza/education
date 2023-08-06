package telran.employees.service;

import java.util.List;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;
import telran.net.TCPClientJava;

public class EmployeeTcpProxy extends TCPClientJava implements IEMployees {

	public EmployeeTcpProxy(String hostname, int port) throws Exception {
		super(hostname, port);
	}

	@Override
	public boolean hireEmployee(Employee emp) {
		return sendRequestGetResponse("hireEmployee", emp);
	}

	@Override
	public boolean fireEmployee(int id) {
		return sendRequestGetResponse("fireEmployee", id);
	}

	@Override
	public Employee getEmployeeData(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeesData(int salaryFrom, int salaryTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanySalary> getCompaniesAvgSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanySalary> getCompaniesGreaterAvgSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAvgSalary() {
		// TODO Auto-generated method stub
		return 0;
	}

}
