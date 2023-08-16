package telran.cars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import telran.cars.model.IRentCompany;
import telran.cars.model.RentCompanyEmbedded;
import telran.server.ProtocolJava;
import telran.server.ServerJava;

public class RentCompanyServerAppl {
	private static final String FILE_NAME = "compant.data";
	private static final int PORT = 2000;
	private static final int TIME_OUT = 10_000;
//	private static final int N_THREADS = 10;

	public static void main(String[] args) {
		IRentCompany service = RentCompanyEmbedded.restoreFromFile(FILE_NAME);
		ProtocolJava protocol = new RentCompanyProtocol(service);
		int threads = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(threads - 1);
		ServerJava server = new ServerJava(protocol, PORT, executor, TIME_OUT);
	}

}
