
public class ThreadsGame implements Runnable {
	private int distance;
	private static final int MIN_SLEEP = 2;
	private static final int MAX_SLEEp = 5;

	public ThreadsGame(int distance) {
		super();
		this.distance = distance;
	}

	
	@Override
	public void run() {
		for (int i = 0; i < distance; i++) {
			System.out.println("You Win ");
		}
	}

}
