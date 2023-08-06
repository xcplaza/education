package client;
import telran.net.TCPClientJava;
import java.io.Serializable;

public class CalculatorClient extends TCPClientJava {

	public CalculatorClient(String hostname, int port) throws Exception {
		super(hostname, port);
	}

	public double calculate(Double op1, Double op2, String oper) {
		String requestType = oper;
		Double[] requestData = { op1, op2 };
		Double res = sendRequestGetResponse(requestType, requestData);
		return res;
	}

}
