import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class ThreadsGame extends Thread {
	private int distance;
	private static final int MIN_SLEEP = 2;
	private static final int MAX_SLEEP = 5;

	public ThreadsGame(int distance) {
		super();
		this.distance = distance;
	}

	Random random = new Random();
	int value = random.nextInt(MAX_SLEEP - MIN_SLEEP + 1) + MIN_SLEEP;

	Instant start = Instant.now();
//	ThreadsGame game = new ThreadsGame(distance);

	@Override
	public void run() {
		for (int i = 0; i < distance; i++) {
			try {
				Thread.sleep(value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(
					"I'm threads " + i + " my time " + ChronoUnit.MILLIS.between(start, Instant.now()));
		}
	}

}
