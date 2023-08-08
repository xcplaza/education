import java.util.Scanner;

public class PrinterController {

	public static void main(String[] args) {
		Printer printer = new Printer("abc");
		Scanner scanner = new Scanner(System.in);
		printer.start();
		while (true) {
			String line = scanner.nextLine();
			if (line.equalsIgnoreCase("q"))
				break;
			printer.interrupt();
		}
		scanner.close();
	}
}
