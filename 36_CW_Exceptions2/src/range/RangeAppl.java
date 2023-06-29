package range;

public class RangeAppl {

	private static final int MIN_RANGE = 100;
	private static final int MAX_RANGE = 1000;
//	for random
	private static final int N_NUMBERS = 10000; // сколько рандомальных чисел мы создаем
	private static final int MIN_RANDOM = 0;
	private static final int MAX_RANDOM = 10000;

	public static void main(String[] args) {
		int countRight = 0;
		int countLess = 0;
		int countMore = 0;

		Range range = null;
		try {
			range = new Range(MIN_RANGE, MAX_RANGE);
		} catch (Exception e) {
		}

		for (int i = 0; i < N_NUMBERS; i++) {
			int random = (int) (MIN_RANDOM + Math.random() * (MAX_RANDOM - MIN_RANDOM + 1));
			try {
				range.checkNumber(random);
				countRight++;
			} catch (NumberLessMinException e) {
				countLess++;
			} catch (NumberMoreMaxException e) {
				countMore++;
			}catch (Exception e) {
				
			}
		}
		System.out.printf("count right = %d\ncount less = %d\ncount more = %d", countRight, countLess, countMore);
	}
}
