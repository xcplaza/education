package telran.range;

import java.util.Iterator;

public class Range implements Iterable<Integer> {
	private int min; // -1
	private int max; // 12

	public Range(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new MyRangeIterator(this);
	}

}
