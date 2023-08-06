package server;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TCPResponseCode;
import telran.server.ProtocolJava;

public class ProtocolCalculator implements ProtocolJava {
	static Map<String, BinaryOperator<Double>> mapOperations;
	static {
		mapOperations = new HashMap<>();
		mapOperations.put("+", (x, y) -> x + y);
		mapOperations.put("-", (x, y) -> x - y);
		mapOperations.put("x", (x, y) -> x * y);
		mapOperations.put("/", (x, y) -> y == 0 ? null : x / y);
	}

	@Override
	public ResponseJava getResponse(RequestJava request) {
		String operator = request.requestType;
		Double[] data = (Double[]) request.requestData;
		double res = mapOperations.get(operator).apply(data[0], data[1]);
		ResponseJava resp = new ResponseJava(TCPResponseCode.OK, res);
		return resp;
	}

}
