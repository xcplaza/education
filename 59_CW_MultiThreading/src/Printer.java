
public class Printer extends Thread {
	char symb;
	int nPrints;

	public Printer(char symb, int nPrints) {
		super();
		this.symb = symb;
		this.nPrints = nPrints;
	}

	@Override
	public void run() {
		for (int i = 0; i < nPrints; i++) {
			System.out.println(symb);
			try {
				sleep(3);
			} catch (InterruptedException e) {
			}
		}
	}
}
