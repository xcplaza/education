package telran.employee.service;

import java.util.List;

import telran.employee.dto.CompanySalary;
import telran.employee.dto.Employee;

public interface IEmployees
{
	boolean hireEmployee(Employee emp);
	boolean fireEmployee(int id);
	Employee getEmployeeData(int id);
	List<Employee> getEmployeesDataBySalary(int salaryFrom, int salaryTo);
	List<CompanySalary> getCompaniesAvgSalary();
	List<CompanySalary> getCompaniesGreaterAvgSalary();
	int getAvgSalary();
}
