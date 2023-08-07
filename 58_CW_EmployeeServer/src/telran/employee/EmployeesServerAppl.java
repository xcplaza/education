package telran.employee;

import telran.employee.net.EmployeesTcpProtocol;
import telran.employee.service.EmployeesMap;
import telran.employee.service.IEmployees;
import telran.server.ProtocolJava;
import telran.server.ServerJava;

public class EmployeesServerAppl
{

	private static final int PORT = 2000;

	public static void main(String[] args) throws Exception
	{
		IEmployees employees = new EmployeesMap();
		ProtocolJava protocol = new EmployeesTcpProtocol(employees);
		ServerJava server = new ServerJava(protocol, PORT);
		server.run();

	}

}
