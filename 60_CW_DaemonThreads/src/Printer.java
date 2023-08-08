
public class Printer extends Thread {
	private String str;
	private int length;

	public Printer(String str) {
		super();
		setDaemon(true);
		this.str = str;
		length = str.length();
	}

	@Override
	public void run() {
		int ind = 0;
		while (true) {
			System.out.println(str.charAt(ind));
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				ind++;
				if (ind == length)
					ind = 0;
			}
		}
	}
}
