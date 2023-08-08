public class PrinterNumb extends Thread {

	private static final int PORCION = 10;
	private static final int MAX_COUNT = 100;
	private PrinterNumb next;
	private int numb;

	public PrinterNumb(int numb, PrinterNumb next) {
		super();
		this.numb = numb;
		this.next = next;
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				if (count >= MAX_COUNT)
					break;
				for (int i = 0; i < PORCION; i++) {
					System.out.print(numb);
				}
				System.out.println();
				count += PORCION;
				next.interrupt();
			}
		}
	}

	public void setNext(PrinterNumb next) {
		this.next = next;
	}

	public void setNumb(int numb) {
		this.numb = numb;
	}

}