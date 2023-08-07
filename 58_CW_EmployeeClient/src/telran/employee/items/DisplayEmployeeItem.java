package telran.employee.items;

import telran.employee.service.IEmployees;
import telran.view.*;


public class DisplayEmployeeItem extends EmployeesItem
{
	public DisplayEmployeeItem(InputOutput inputOutput, IEmployees employees)
	{
		super(inputOutput, employees);
	}

	@Override
	public String displayName()
	{
		return "Display employee data";
	}

	@Override
	public void perform()
	{
		Integer id = getExistingId();
		if (id == null)
			return;
		inputOutput.outputLine(employees.getEmployeeData(id));
	}
}
