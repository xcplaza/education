import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class GroupPerformanceTest {
	GroupSum groupSum;

	public GroupPerformanceTest(GroupSum groupSum) {
		super();
		this.groupSum = groupSum;
	}

	public void runTest() {
		Instant start = Instant.now();
		long sum = groupSum.computeSum();
		System.out.printf("Test: %s, running time: %d, sum = %d\n ", groupSum.getClass().getSimpleName(),
				ChronoUnit.MILLIS.between(start, Instant.now()), sum);
	}

}
