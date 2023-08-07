package telran.employee.items;

import telran.employee.dto.Employee;
import telran.employee.service.IEmployees;
import telran.view.*;

public class HireEmployeeItem extends EmployeesItem
{

	public HireEmployeeItem(InputOutput inputOutput, IEmployees employees)
	{
		super(inputOutput, employees);
	}

	@Override
	public String displayName()
	{
		return "Hire new Employee";
	}

	@Override
	public void perform()
	{
		Integer id = getNotExistingId();
		if(id == null)
			return;
		
		String name = inputOutput.inputString("Enter name");
		if(name == null)
			return;
		
		String companyName = inputOutput.inputString("Enter company name");
		if(companyName == null)
			return;
		
		Integer salary = inputOutput.inputInteger
				(String.format("Enter salary [%d-%d]", MIN_SALARY, MAX_SALARY), MIN_SALARY, 
						MAX_SALARY);
		if(salary == null)
			return;
		
		if(employees.hireEmployee(new Employee(id, name, companyName, salary)))
			inputOutput.outputLine("Employee has been succesfully hired");
	}

}
