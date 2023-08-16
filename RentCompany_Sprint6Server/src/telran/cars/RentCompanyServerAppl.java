package telran.cars;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import telran.cars.model.IRentCompany;
import telran.cars.model.RentCompanyEmbedded;
import telran.cars.model.RentCompanyProtocol;
import telran.server.ProtocolJava;
import telran.server.ServerJava;
import telran.util.Persistable;

public class RentCompanyServerAppl {
	private static final String FILE_NAME = "company.data";
	private static final int PORT = 2000;
	private static final int TIMEOUT = 10_000;
//	private static final int N_THREADS = 10;

	public static void main(String[] args) throws Exception {
		IRentCompany service = RentCompanyEmbedded.restoreFromFile(FILE_NAME);
		ProtocolJava protocol = new RentCompanyProtocol(service);
		int threads = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(threads - 1);
		ServerJava server = new ServerJava(protocol, PORT, executor, TIMEOUT);
		executor.execute(server);

		Scanner scanner = new Scanner(System.in);
		while (true) {
			String line = scanner.nextLine();
			if (line.equalsIgnoreCase("exit"))
				break;
		}
		((Persistable) service).save(FILE_NAME);
		executor.shutdown();
		server.shutdown();
		executor.awaitTermination(TIMEOUT + 1000, TimeUnit.MILLISECONDS); // принудительный выход! (не обязательно)
		scanner.close();
	}

}
