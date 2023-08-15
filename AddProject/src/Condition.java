
public class Condition {
	private int count = 0; // счетчик потоков
	final static int THREADS_COUNT = 10; // сколько потоков
	private final Object monitor = new Object();

	public void barrier() {
		synchronized (monitor) {
			count++;
			if (count < THREADS_COUNT) {
				try {
					monitor.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				monitor.notifyAll();
			}
		}
	}

}
