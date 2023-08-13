import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceGroupSum extends GroupSum {
	int nThreads;

	public ExecutorServiceGroupSum(int[][] number) {
		super(number);
		Runtime runTime = Runtime.getRuntime();
		nThreads = runTime.availableProcessors();
		System.out.println("Processors " + nThreads);
	}

	public void setnThreads(int nThreads) {
		this.nThreads = nThreads;
	}

	@Override
	public long computeSum() {
		ExecutorService pool = Executors.newFixedThreadPool(nThreads);
		OneGroupSum[] groups = launchExecutor(pool);
		waitThreads(pool);
		return computeGroup(groups);
	}

	private long computeGroup(OneGroupSum[] groups) {
		return Arrays.stream(groups).mapToLong(e -> e.getSum()).sum();
	}

	private void waitThreads(ExecutorService pool) {
		pool.shutdown(); // disable execute
//		pool.isTerminated(); // OR
		try {
			pool.awaitTermination(20, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private OneGroupSum[] launchExecutor(ExecutorService pool) {
		OneGroupSum[] res = new OneGroupSum[number.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = new OneGroupSum(number[i]); // tasks
			pool.execute(res[i]);
		}
		return res;
	}

}
