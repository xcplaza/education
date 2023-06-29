package telran.range;

public class RangeAppl {

	public static void main(String[] args) {
		int min = -5;
		int max = 5;

		Range range = new Range(min, max);
		for (Integer n : range) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		MyRangeIteratorRevers rev = new MyRangeIteratorRevers(range);
		while (rev.hasNext()) {
			System.out.print(rev.next() + " ");
		}
		System.out.println();
	}

}
