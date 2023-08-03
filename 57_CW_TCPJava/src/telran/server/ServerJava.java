package telran.server;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerJava implements Runnable {
	ServerSocket serverSocket;
	ProtocolJava protocol;
	int port;

	public ServerJava(ProtocolJava protocol, int port) throws Exception {
		super();
		this.protocol = protocol;
		this.port = port;
		serverSocket = new ServerSocket(port);
	}

	@Override
	public void run() {
		System.out.println("Listening on port " + port);
		try {
			while (true) {
				Socket socket = serverSocket.accept();
				ServerClientJava worker = new ServerClientJava(socket, protocol);
				worker.run();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
