package deadlock;

public class Worker extends Thread {
	private static final Object mutex1 = new Object();
	private static final Object mutex2 = new Object();

	void method1() {
		synchronized (mutex1) {
//			worker
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (mutex2) {
//				worker
			}
		}
	}

	void method2() {
		synchronized (mutex2) {
			synchronized (mutex1) {
//				worker
			}
		}
	}

	@Override
	public void run() {
		method1();
		method2();
	}
}
