
import java.util.Arrays;

public class GroupSumStreamParalels extends GroupSum {

	public GroupSumStreamParalels(int[][] number) {
		super(number);
	}

	@Override
	public long computeSum() {
		return Arrays.stream(number).parallel().flatMapToLong(x -> Arrays.stream(x).asLongStream()).sum();
	}

}
