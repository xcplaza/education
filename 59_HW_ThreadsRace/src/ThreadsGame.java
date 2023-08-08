import java.util.Random;

public class ThreadsGame implements Runnable {
	private final int id;
	private int distance;
	private static final int MIN_SLEEP = 2;
	private static final int MAX_SLEEP = 5;
	private static int winner = 0;

	public ThreadsGame(int id, int distance) {
		this.id = id;
		this.distance = distance;
	}

	@Override
	public void run() {
		Random random = new Random();
		for (int i = 0; i < distance; i++) {
			try {
				Thread.sleep(random.nextInt(MAX_SLEEP - MIN_SLEEP + 1) + MIN_SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Line " + id + ": " + i + " distance");
		}
		if (winner == 0) {
			winner = id;
			System.err.println("\nWinner Line " + winner + " is finished!\n");
		}
//		Thread.interrupted();
	}
}