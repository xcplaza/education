
import java.util.Arrays;

public class GroupSumStream extends GroupSum {

	public GroupSumStream(int[][] number) {
		super(number);
	}

	@Override
	public long computeSum() {
		return Arrays.stream(number).flatMapToLong(x -> Arrays.stream(x).asLongStream()).sum();
	}

}
