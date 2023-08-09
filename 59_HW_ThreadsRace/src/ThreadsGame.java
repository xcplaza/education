import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ThreadsGame implements Runnable {
//	private final int id;
	private int distance;
	private static final int MIN_SLEEP = 2;
	private static final int MAX_SLEEP = 5;
//	private static int winner = 0;
	@SuppressWarnings("unused")
	private static final Object mutex = new Object();

	public ThreadsGame(int id, int distance) {
//		this.id = id;
		this.distance = distance;
	}

	List<Integer> list = new ArrayList<>();

	@Override
	synchronized public void run() {
		Random random = new Random();
		Instant start = Instant.now();
		int ind = 1;
		for (int i = 0; i < distance; i++) {
			try {
				Thread.sleep(random.nextInt(MAX_SLEEP - MIN_SLEEP + 1) + MIN_SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			System.out.println("Line " + id + ": " + i + " distance");
			list.add(i);
		}
//		if (winner == 0) {
//			winner = id;
//			System.err.println("\nWinner Line " + winner + " is finished!\n");
		System.out.println("Place\tThreads\tTime");
		IntStream.range(0, list.size()).forEach(i -> System.out.printf(" %d\t %d\t %d\n", i + 1, list.get(i),
				ChronoUnit.MILLIS.between(start, Instant.now())));
//		}
//		Thread.interrupted();
	}
}