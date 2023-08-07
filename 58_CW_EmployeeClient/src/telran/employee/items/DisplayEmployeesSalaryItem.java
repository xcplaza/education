package telran.employee.items;

import telran.employee.service.IEmployees;
import telran.view.*;


public class DisplayEmployeesSalaryItem extends EmployeesItem
{
	public DisplayEmployeesSalaryItem(InputOutput inputOutput, IEmployees employees)
	{
		super(inputOutput, employees);
	}

	@Override
	public String displayName()
	{
		return "Display data about employees getting salary in a given range";
	}

	@Override
	public void perform()
	{
		Integer salaryFrom = inputOutput.inputInteger(String.format("Enter salary from [%d-%d]", 
				MIN_SALARY, MAX_SALARY), MIN_SALARY, MAX_SALARY);
		if (salaryFrom == null)
			return;
		Integer salaryTo = inputOutput.inputInteger(String.format("Enter salary to [%d-%d]", 
				MIN_SALARY, MAX_SALARY), MIN_SALARY, MAX_SALARY);
		if (salaryTo == null)
			return;
		if (salaryTo < salaryFrom)
		{
			inputOutput.outputLine("salary to can't be less than salary from");
			return;
		}
		employees.getEmployeesDataBySalary(salaryFrom, salaryTo)
		.forEach(inputOutput::outputLine);
	}
}
