package telran.range;

import java.util.Iterator;

public class MyRangeIterator implements Iterator<Integer> {
	private Range range;
	private int position;

	public MyRangeIterator(Range range) {
		super();
		this.range = range;
		position = range.getMin();
	}

	@Override
	public boolean hasNext() {
		return position <= range.getMax();
	}

	@Override
	public Integer next() {
		return position++;
	}
}
