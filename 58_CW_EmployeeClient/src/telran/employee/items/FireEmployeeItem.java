package telran.employee.items;

import telran.employee.service.IEmployees;
import telran.view.*;


public class FireEmployeeItem extends EmployeesItem
{
	public FireEmployeeItem(InputOutput inputOutput, IEmployees employees)
	{
		super(inputOutput, employees);
	}

	@Override
	public String displayName()
	{
		return "Fire employee";
	}

	@Override
	public void perform()
	{
		Integer id = getExistingId();
		if (id == null)
			return;
		if (employees.fireEmployee(id))
		{
			inputOutput.outputLine("Employee has been fired");
		}
	}
}
