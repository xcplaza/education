package telran.employees.service;

import java.util.List;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;

public interface IEMployees {
	boolean hireEmployee(Employee emp);
	boolean fireEmployee(int id);
	Employee getEmployeeData(int id);
	List<Employee> getEmployeesData(int salaryFrom, int salaryTo);
	List<CompanySalary> getCompaniesAvgSalary();
	List<CompanySalary> getCompaniesGreaterAvgSalary();
	int getAvgSalary();
}
