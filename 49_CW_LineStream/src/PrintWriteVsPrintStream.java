import java.io.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

public class PrintWriteVsPrintStream {

	private static final int N_LINES = 1_000_000;
	private static final String STRING = "hello";

	public static void main(String[] args) {
		testPrintWriter();
		testPrintStream();
	}

	private static void testPrintStream() {
		try (PrintStream writer = new PrintStream("test1.txt")) {
			LocalTime start = LocalTime.now();
			IntStream.range(0, N_LINES).forEach(i -> writer.println(STRING));
			printResult("PrintStream ", start, LocalTime.now());

		} catch (Exception e) {
		}
	}

	private static void testPrintWriter() {
		try (PrintWriter writer = new PrintWriter("test.txt")) {
			LocalTime start = LocalTime.now();
			IntStream.range(0, N_LINES).forEach(i -> writer.println(STRING));
			printResult("PrintWriter ", start, LocalTime.now());

		} catch (Exception e) {
		}
	}

	private static void printResult(String string2, LocalTime start, LocalTime now) {
		System.out.printf("Running time for %s is %d\n", string2, ChronoUnit.MILLIS.between(start, now));
	}

}
