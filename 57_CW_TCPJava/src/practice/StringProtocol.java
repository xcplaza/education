package practice;

import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TCPResponseCode;
import telran.server.ProtocolJava;

public class StringProtocol implements ProtocolJava {

	@Override
	public ResponseJava getResponse(RequestJava request) {

		String data = (String) request.requestData;
		switch (request.requestType) {
		case "length":
			return getLength(data);
		case "revers":
			return getReversString(data);
		default:
			return new ResponseJava(TCPResponseCode.UNKNOWN, null);
		}
	}

	private ResponseJava getReversString(String data) {
		try {
			char[] temp = data.toCharArray();
			String res = "";
			for (char c : temp)
				res = c + res;
			return new ResponseJava(TCPResponseCode.OK, res);
		} catch (Exception e) {
			return new ResponseJava(TCPResponseCode.WRONG_REQUEST, null);
		}
	}

	private ResponseJava getLength(String data) {
		try {
			return new ResponseJava(TCPResponseCode.OK, data.length());
		} catch (Exception e) {
			return new ResponseJava(TCPResponseCode.WRONG_REQUEST, null);
		}
	}

}
