package practice;

import telran.server.ServerJava;

public class StringServerAppl {

	public static void main(String[] args) throws Exception {
		ServerJava server = new ServerJava(new StringProtocol(), 3000);
		server.run();
	}

}
