package telran.employee;

import telran.employee.items.*;
import telran.employee.items.HireEmployeeItem;
import telran.employee.service.EmployeesTcpProxy;
import telran.employee.service.IEmployees;
import telran.view.*;


public class EmployeesClientAppl
{

	private static final String HOST = "localhost";
	private static final int PORT = 2000;

	public static void main(String[] args) throws Exception
	{
		InputOutput inputOutput = new ConsoleInputOutput();
		IEmployees employees = new EmployeesTcpProxy(HOST, PORT);
		
		Item[] items = 
				{
						new HireEmployeeItem(inputOutput, employees),
						new FireEmployeeItem(inputOutput, employees),
						new DisplayEmployeeItem(inputOutput, employees),
						new DisplayEmployeesSalaryItem(inputOutput, employees),
						new DisplayAvgSalaryItem(inputOutput, employees),
						new DisplayCompaniesAvgSalaryGreaterItem(inputOutput, employees),
						new DisplayCompaniesSalariesItem(inputOutput, employees),
						new CloseConnectionAndExitItem(inputOutput, employees),
						new ExitItem()
				};
		
		Menu menu = new Menu(items, inputOutput);
		menu.runMenu();
	}
}
