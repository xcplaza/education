import java.util.Random;

public class GroupSunAppl {
	private static final int N_GROUPS = 1_000; // количество мешков
	private static final int N_NUMBERS = 10_000; // количество гранат в мешке

	public static void main(String[] args) {
		int[][] numbers = getRandomNumbers();
		ExecutorServiceGroupSum service = new ExecutorServiceGroupSum(numbers);
		GroupPerformanceTest test = new GroupPerformanceTest(service);

		for (int nThreads = 1000; nThreads <= 10000; nThreads += 1000) {
			System.out.println("nThreads " + nThreads);
			service.setnThreads(nThreads);
			test.runTest();
		}
		test.runTest();
	}

	private static int[][] getRandomNumbers() {
		Random random = new Random();
		int[][] res = new int[N_GROUPS][N_NUMBERS];
		for (int i = 0; i < N_GROUPS; i++) {
			res[i] = random.ints(N_NUMBERS, 1, Integer.MAX_VALUE).toArray();
		}
		return res;
	}
}
