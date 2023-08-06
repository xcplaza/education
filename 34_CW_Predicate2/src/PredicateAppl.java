import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateAppl {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		Predicate<Integer> predicate = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
		};
		int[] range = getRange(ar, predicate);
		System.out.println(Arrays.toString(range));

		PredicateByRange predicate2 = new PredicateByRange(1, 7);
		range = getRange(ar, predicate2);
		System.out.println(Arrays.toString(range));

		predicate2.setMax(9);
		range = getRange(ar, predicate2);
		System.out.println(Arrays.toString(range));

//		negate - противоположне от указанного в predicate
		Predicate<Integer> predicate3 = predicate2.negate();
		range = getRange(ar, predicate3);
		System.out.println(Arrays.toString(range));

		Predicate<Integer> predicate4 = predicate.and(predicate2);
		range = getRange(ar, predicate);
		System.out.println(Arrays.toString(range));
	}

//	вывод самих элементов
	private static int[] getRange(int[] ar, Predicate<Integer> predicate) {
		int count = getCount(ar, predicate);
		int[] res = new int[count];
		int iRes = 0;
		for (int i = 0; i < ar.length; i++) {
			if (predicate.test(ar[i]))
				res[iRes++] = ar[i];
		}
		return res;
	}

//	 сколько элементов в массиве
	private static int getCount(int[] ar, Predicate<Integer> predicate) {
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			if (predicate.test(ar[i]))
				count++;
		}
		return count;
	}

}
