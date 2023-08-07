package telran.employee.service;

import java.util.List;

import telran.employee.dto.CompanySalary;
import telran.employee.dto.Employee;
import telran.net.TCPClientJava;

public class EmployeesTcpProxy extends TCPClientJava implements IEmployees
{

	public EmployeesTcpProxy(String hostname, int port) throws Exception
	{
		super(hostname, port);
	}

	@Override
	public boolean hireEmployee(Employee emp)
	{
		return sendRequestGetResponse("hireEmployee", emp);
	}

	@Override
	public boolean fireEmployee(int id)
	{
		return sendRequestGetResponse("fireEmployee", id);
	}

	@Override
	public Employee getEmployeeData(int id)
	{
		return sendRequestGetResponse("getEmployeeData", id);
	}

	@Override
	public List<Employee> getEmployeesDataBySalary(int salaryFrom, int salaryTo)
	{
		Integer[] data = {salaryFrom, salaryTo};
		return sendRequestGetResponse("getEmployeesDataBySalary", data);
	}

	@Override
	public List<CompanySalary> getCompaniesAvgSalary()
	{
		return sendRequestGetResponse("getCompaniesAvgSalary", null);
	}

	@Override
	public List<CompanySalary> getCompaniesGreaterAvgSalary()
	{
		return sendRequestGetResponse("getCompaniesGreaterAvgSalary", null);
	}

	@Override
	public int getAvgSalary()
	{
		return sendRequestGetResponse("getAvgSalary", null);
	}
}
