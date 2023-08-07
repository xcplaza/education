package telran.employees.item;

import telran.employees.service.IEmployees;
import telran.view.InputOutput;
import telran.view.Item;

public abstract class EmployeesItem implements Item {
	protected InputOutput inputOutput;
	protected IEmployees employees;
	public EmployeesItem(InputOutput inputOutput, IEmployees employees) {
		super();
		this.inputOutput = inputOutput;
		this.employees = employees;
	}
	
	

}
