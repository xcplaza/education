import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

public class CollectionAppl {
	private static final int N_THREADS = 10;
	private static final int PROB_UPDATE = 1;
	private static final int N_RUNS = 1000;
	private static final int N_NUMBERS = 100;

	public static void main(String[] args) {
		var threads = new CollectionProcessingThread[N_THREADS];
		startThreads(threads);
		waitThreads(threads);
		System.out.println(CollectionProcessingThread.countLock);
	}

	private static void waitThreads(CollectionProcessingThread[] threads) {
		for (CollectionProcessingThread th : threads) {
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void startThreads(CollectionProcessingThread[] threads) {
		Collection<Integer> collection = new Random().ints(N_NUMBERS, 1, 100).boxed().collect(Collectors.toList());
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new CollectionProcessingThread(collection, N_RUNS, PROB_UPDATE);
			threads[i].start();
		}
	}

}
