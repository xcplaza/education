package telran.employee.items;

import telran.employee.service.IEmployees;
import telran.view.*;


public class DisplayCompaniesSalariesItem extends EmployeesItem
{
	public DisplayCompaniesSalariesItem(InputOutput inputOutput, IEmployees employees)
	{
		super(inputOutput, employees);
	}

	@Override
	public String displayName()
	{
		return "Display companies and their average salaries";
	}

	@Override
	public void perform()
	{
		employees.getCompaniesAvgSalary().forEach(inputOutput::outputLine);
	}
}
