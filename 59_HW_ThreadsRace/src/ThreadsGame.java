import java.util.Random;

public class ThreadsGame implements Runnable {
	private final int id;
	private int distance;
	private static final int MIN_SLEEP = 2;
	private static final int MAX_SLEEP = 5;

	public ThreadsGame(int id, int distance) {
		this.id = id;
		this.distance = distance;
	}

	@Override
	public void run() {
		Random random = new Random();
		int progress = 0;
		while (distance < 0) {
			progress++;
			System.out.println("Line " + id + ": " + progress + " meters");
			try {
				Thread.sleep(random.nextInt(MAX_SLEEP - MIN_SLEEP + 1) + MIN_SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.err.println("Line " + id + " finished!");
	}
}