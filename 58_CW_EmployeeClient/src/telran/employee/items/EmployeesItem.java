package telran.employee.items;

import telran.employee.dto.Employee;
import telran.employee.service.IEmployees;
import telran.view.*;


public abstract class EmployeesItem implements Item
{
	protected InputOutput inputOutput;
	protected IEmployees employees;
	protected final int MIN_SALARY = 6000;
	protected final int MAX_SALARY = 60000;
	
	public EmployeesItem(InputOutput inputOutput, IEmployees employees)
	{
		super();
		this.inputOutput = inputOutput;
		this.employees = employees;
	}
	
	protected Integer getNotExistingId()
	{
		Integer id = inputOutput.inputInteger("Enter new unique identifier");
		if(id == null)
			return null;
		
		if(employees.getEmployeeData(id) != null)
		{
			inputOutput.outputLine("Employee already exists");
			return null;
		}
		
		return id;
	}
	
	protected Integer getExistingId()
	{
		Integer id = inputOutput.inputInteger("Enter identifier");
		if (id == null)
			return null;
		Employee empl = employees.getEmployeeData(id);
		if (empl == null)
		{
			inputOutput.outputLine("Employee with the entered ID not found");
			return null;
		}
		return id;
	}
}
