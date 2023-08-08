public class PrinterNumbController {

	public static void main(String[] args) {
		PrinterNumb printer4 = new PrinterNumb(4, null);
		PrinterNumb printer3 = new PrinterNumb(3, printer4);
		PrinterNumb printer2 = new PrinterNumb(2, printer3);
		PrinterNumb printer1 = new PrinterNumb(1, printer2);
		printer4.setNext(printer1);

		printer1.start();
		printer2.start();
		printer3.start();
		printer4.start();

		printer1.interrupt();
	}

}
