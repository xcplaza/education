package telran.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class TCPClientJava implements Closeable {

	protected ObjectInputStream input;
	protected ObjectOutputStream output;
	protected Socket socket;

	public TCPClientJava(String hostname, int port) throws Exception {
		socket = new Socket(hostname, port);
		output = new ObjectOutputStream(socket.getOutputStream());
		input = new ObjectInputStream(socket.getInputStream());
	}

	@Override
	public void close() throws IOException {
		socket.close();
	}

	@SuppressWarnings("unchecked")
	protected <T> T sendRequestGetResponse(String requestType, Serializable requestData) {
		try {
			RequestJava request = new RequestJava(requestType, requestData);
			output.writeObject(request);

			ResponseJava response = (ResponseJava) input.readObject();
			if (response.code != TCPResponseCode.OK)
				throw new Exception(response.code.toString() + ": " + response.responseData);
			return (T) response.responseData;

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}
}
