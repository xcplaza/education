import java.util.Arrays;

public class GroupSumThreads extends GroupSum {
	int nThreads;

	public GroupSumThreads(int[][] number) {
		super(number);
		this.nThreads = number.length;
	}

	public int getnThreads() {
		return nThreads;
	}

	@Override
	public long computeSum() {
		OneGroupSum[] groups = makeGroups(nThreads);
//		waitThreads(groups);
		return computeGroup(groups);
	}

	private long computeGroup(OneGroupSum[] groups) {
		return Arrays.stream(groups).mapToLong(e -> e.getSum()).sum();
	}

	private void waitThreads(OneGroupSum[] groups) {
		for (OneGroupSum oneGroupSum : groups) {
			try {
				oneGroupSum.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private OneGroupSum[] makeGroups(int nTreads) {
		OneGroupSum[] res = new OneGroupSum[nTreads];
		for (int i = 0; i <= res.length; i++) {
			res[i] = new OneGroupSum(number[i]);
			res[i].run();
		}
		return res;
	}

}
