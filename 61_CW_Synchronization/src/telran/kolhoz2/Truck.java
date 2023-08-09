package telran.kolhoz2;

import java.util.concurrent.atomic.AtomicLong;

public class Truck extends Thread {
	int load;
	int nLoads;
	private static AtomicLong elev1 = new AtomicLong(0);
	private static AtomicLong elev2 = new AtomicLong(0);

	public Truck(int load, int nLoads) {
		super();
		this.load = load;
		this.nLoads = nLoads;
	}

	public static long getElev1() {
		return elev1.get();
	}

	public static long getElev2() {
		return elev2.get();
	}

	@Override
	public void run() {
		for (int i = 0; i < nLoads; i++) {
			loadElev1(load);
			loadElev2(load);

		}
	}

	private static void loadElev2(int load) {
		elev2.addAndGet(load);
	}

	private void loadElev1(int load) {
		elev1.addAndGet(load);
	}
}
