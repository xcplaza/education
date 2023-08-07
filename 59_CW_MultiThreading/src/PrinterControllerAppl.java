import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class PrinterControllerAppl {
	private static final int N_PRINTS = 100;

	public static void main(String[] args) throws InterruptedException {
		Printer pr1 = new Printer('#', N_PRINTS);
		Printer pr2 = new Printer('*', N_PRINTS);

//		join main
//		Thread.currentThread().join();
		
		Instant start = Instant.now();
//		no multi threads
//		pr1.run();
//		pr2.run();

//		start multi threads
		pr1.start();
		pr2.start();
		pr1.join();
		pr2.join();
		System.out.printf("Printing time is %d\n", ChronoUnit.MILLIS.between(start, Instant.now()));
	}

}
