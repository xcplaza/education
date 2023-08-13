import java.util.Arrays;

public class OneGroupSum implements Runnable {
	int[] group; // количество зерен в гранате
	long sum;

//	сумма зерен в мешке (в каждом)
	public OneGroupSum(int[] group) {
		super();
		this.group = group;
	}

	public long getSum() {
		return sum;
	}

	@Override
	public void run() {
		sum = Arrays.stream(group).asLongStream().sum();
	}
}
