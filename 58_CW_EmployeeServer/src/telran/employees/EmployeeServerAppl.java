package telran.employees;

import telran.employees.net.EmployessTcpProtocol;
import telran.employees.service.EmployeesMaps;
import telran.employees.service.IEMployees;
import telran.server.ProtocolJava;
import telran.server.ServerJava;

public class EmployeeServerAppl {

	public static void main(String[] args) throws Exception {
		IEMployees service = new EmployeesMaps();
		ProtocolJava protocol = new EmployessTcpProtocol(service);
		ServerJava server = new ServerJava(protocol, 2000);
		server.run();
	}

}
