package telran.employees.item;

import telran.employees.service.IEMployees;
import telran.view.InputOutput;
import telran.view.Item;

public abstract class EmployeesItem implements Item {
	protected InputOutput inputOutput;
	protected IEMployees employees;

	public EmployeesItem(InputOutput inputOutput, IEMployees employees) {
		super();
		this.inputOutput = inputOutput;
		this.employees = employees;
	}

}
