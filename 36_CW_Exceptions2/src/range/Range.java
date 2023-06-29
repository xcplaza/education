package range;

public class Range {
	int min, max;

	public Range(int min, int max) throws Exception {
		super();
		if (min >= max)
			throw new Exception("min >= max");
		this.min = min;
		this.max = max;
	}

	public void checkNumber(int number) throws NumberLessMinException, NumberMoreMaxException{
		if (number < min)
			throw new NumberLessMinException(number + " < min");
		if (number > max)
			throw new NumberMoreMaxException(number + " > max");
	}

}
