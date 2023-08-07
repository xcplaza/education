package telran.employee.items;

import telran.employee.service.IEmployees;
import telran.view.*;


public class DisplayCompaniesAvgSalaryGreaterItem extends EmployeesItem
{
	public DisplayCompaniesAvgSalaryGreaterItem(InputOutput inputOutput, IEmployees employees)
	{
		super(inputOutput, employees);
	}

	@Override
	public String displayName()
	{
		return "Display companies with average salary greater than total average value";
	}

	@Override
	public void perform()
	{
		employees.getCompaniesGreaterAvgSalary().forEach(inputOutput::outputLine);
	}
}
