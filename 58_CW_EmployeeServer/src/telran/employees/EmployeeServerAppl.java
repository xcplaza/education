package telran.employees;

import telran.employees.net.EmployeesTcpProtocol;
import telran.employees.service.EmployeesMaps;
import telran.employees.service.IEmployees;
import telran.server.ProtocolJava;
import telran.server.ServerJava;

public class EmployeeServerAppl {

	public static void main(String[] args) throws Exception {
		IEmployees service = new EmployeesMaps();
		ProtocolJava protocol = new EmployeesTcpProtocol(service);
		ServerJava server = new ServerJava(protocol, 2000);
		server.run();

	}

}
