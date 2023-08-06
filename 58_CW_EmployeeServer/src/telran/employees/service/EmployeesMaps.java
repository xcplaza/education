package telran.employees.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;

public class EmployeesMaps implements IEMployees {

	HashMap<Integer, Employee> employees;
	HashMap<String, List<Employee>> companies;
	TreeMap<Integer, List<Employee>> salaries;

	public EmployeesMaps() {
		employees = new HashMap<>();
		companies = new HashMap<>();
		salaries = new TreeMap<>();
	}

	@Override
	public boolean hireEmployee(Employee emp) {
		boolean res = employees.putIfAbsent(emp.getId(), emp) == null;
		if (res) {
			addCompanies(emp);
			addSalaries(emp);
		}
		return res;
	}

	private void addSalaries(Employee emp) {
		int salary = emp.getSalary();
		List<Employee> empList = salaries.getOrDefault(salary, new ArrayList<>());
		empList.add(emp);
		salaries.putIfAbsent(salary, empList);
	}

	private void addCompanies(Employee emp) {
		String companyName = emp.getCompanyName();
		List<Employee> empList = companies.getOrDefault(companyName, new ArrayList<>());
		empList.add(emp);
		companies.putIfAbsent(companyName, empList);
	}

	@Override
	public boolean fireEmployee(int id) {
		// TODO Auto-generated method stub
		return false;
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
