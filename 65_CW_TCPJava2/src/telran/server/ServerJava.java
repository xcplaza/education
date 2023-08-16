package telran.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServerJava implements Runnable {
	ServerSocket serverSocket;
	ProtocolJava protocol;
	int port;
	static AtomicBoolean shutdown = new AtomicBoolean(false);
	ExecutorService executor; // многопоточность для сервера
	private int timeOut;

	public ServerJava(ProtocolJava protocol, int port, ExecutorService executor, int timeOut) throws Exception {
		super();
		this.protocol = protocol;
		this.port = port;
		this.timeOut = timeOut;
		serverSocket = new ServerSocket(port);

		serverSocket.setSoTimeout(timeOut);// timeout для server
		this.executor = executor;
	}

	public void shutdown() {
		shutdown.set(true);
	}

	@Override
	public void run() {
		System.out.println("Listening on port " + port);
		try {
			while (!shutdown.get()) { // get - из AtomicBoolean в boolean
				try {
					Socket socket = serverSocket.accept(); // создаем server socket для client
					socket.setSoTimeout(timeOut); // timeout для socket server на server
					ServerClientJava worker = new ServerClientJava(socket, protocol);
					executor.execute(worker); // многоточность
				} catch (SocketTimeoutException e) {
					// ловим exception для setSoTimeout чтобы перезапустить создание server socket
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
