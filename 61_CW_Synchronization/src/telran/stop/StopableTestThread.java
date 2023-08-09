package telran.stop;

public class StopableTestThread extends Thread {
	private volatile boolean stopped = false;

	@Override
	public void run() {
		System.out.println("Run start");
		while (!stopped) {
//			try {
//				Thread.sleep(0);
//			} catch (InterruptedException e) {
//			}
		}
		System.out.println("Run stopped");
	}

	public void askStop() {
		System.out.println("Ask stop");
		stopped = true;
	}
}
