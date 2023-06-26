import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateTestAppl {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Predicate<Integer> predOdd = new PredicateOdd();
		Predicate<Integer> predEven = new PredicateEven();
		Predicate<Integer> predThree = new PredicateThree();

		int[] oddNumbers = getNumbers(ar, predOdd);
		int[] evenNumbers = getNumbers(ar, predEven);
		int[] threeNumbers = getNumbers(ar, predThree);
		displayNumbers("oddNumbers", oddNumbers);
		displayNumbers("evenNumbers", evenNumbers);
		displayNumbers("threeNumbers", threeNumbers);
	}

	private static int[] getNumbers(int[] ar, Predicate<Integer> predicate) {
		int count = getCount(ar, predicate);
		int[] res = new int[count];
		if (count == 0)
			return res;
		int iRes = 0;
		for (int i = 0; i < ar.length; i++) {
			if (predicate.test(ar[i]))
				res[iRes++] = ar[i];
		}
		return res;
	}

	private static int getCount(int[] ar, Predicate<Integer> predicate) {
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			if (predicate.test(ar[i]))
				count++;
		}
		return count;
	}

	private static void displayNumbers(String title, int[] array) {
		System.out.println("*******************************");
		System.out.println(title);
		System.out.println(Arrays.toString(array));
		System.out.println("*******************************");
	}

}
