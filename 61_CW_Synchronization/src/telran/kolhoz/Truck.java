package telran.kolhoz;

public class Truck extends Thread {
	int load;
	int nLoads;
	private static long elev1 = 0;
	private static long elev2 = 0;
	private static final Object mutex = new Object();

	public Truck(int load, int nLoads) {
		super();
		this.load = load;
		this.nLoads = nLoads;
	}

	public static long getElev1() {
		return elev1;
	}

	public static long getElev2() {
		return elev2;
	}

	@Override
	public void run() {
		for (int i = 0; i < nLoads; i++) {
			loadElev1(load);
			loadElev2(load);

		}
	}

	synchronized private static void loadElev2(int load) {
		elev2 += load;
	}

	private void loadElev1(int load) {
		synchronized (mutex) {
			elev1 += load;
		}
	}
}
