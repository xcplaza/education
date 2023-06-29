package telran.range;

import java.util.Iterator;

public class MyRangeIteratorRevers implements Iterator<Double> {
	private Range range;
	private double position;

	public MyRangeIteratorRevers(Range range) {
		super();
		this.range = range;
		position = range.getMax();
	}

	@Override
	public boolean hasNext() {
		return position >= range.getMin();
	}

	@Override
	public Double next() {
		Double res = position;
		position -= 0.5;
		return res;
	}

}
