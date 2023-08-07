package telran.employee.items;

import java.io.Closeable;
import java.io.IOException;

import telran.employee.service.IEmployees;
import telran.view.InputOutput;


public class CloseConnectionAndExitItem extends EmployeesItem
{

	public CloseConnectionAndExitItem(InputOutput inputOutput, IEmployees employees)
	{
		super(inputOutput, employees);
	}

	@Override
	public String displayName()
	{
		return "Close connection and exit";
	}

	@Override
	public void perform()
	{
		try
		{
			((Closeable)employees).close();
		} catch (IOException e)
		{
			inputOutput.outputLine(e.getMessage());
		}
	}

	public boolean isExit()
	{
		return true;
	}
}
