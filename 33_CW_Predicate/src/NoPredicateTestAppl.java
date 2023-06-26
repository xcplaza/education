import java.util.Arrays;
//import java.util.Iterator;

public class NoPredicateTestAppl {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] oddNumbers = getOddNumbers(ar);
		int[] evenNumbers = getEvenNumbers(ar);
		int[] threeNumbers = getThreeNumbers(ar);
		displayNumbers("oddNumbers", oddNumbers);
		displayNumbers("evenNumbers", evenNumbers);
		displayNumbers("threeNumbers", threeNumbers);
	}

	private static int[] getThreeNumbers(int[] ar) {
		int count = countThreeNumbers(ar);
		int[] res = new int[count];
		if (count == 0)
			return res;
		int iRes = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] % 3 == 0)
				res[iRes++] = ar[i];
		}
		return res;
	}

	private static int countThreeNumbers(int[] ar) {
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] % 3 == 0)
				count++;
		}
		return count;
	}

	private static int[] getEvenNumbers(int[] ar) {
		int count = countEvenNumbers(ar);
		int[] res = new int[count];
		if (count == 0)
			return res;
		int iRes = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] % 2 == 0)
				res[iRes++] = ar[i];
		}
		return res;
	}

	private static int countEvenNumbers(int[] ar) {
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] % 2 == 0)
				count++;
		}
		return count;
	}

	private static int[] getOddNumbers(int[] ar) {
		int count = countOddNumbers(ar);
		int[] res = new int[count];
		if (count == 0)
			return res;
		int iRes = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] % 2 != 0)
				res[iRes++] = ar[i];
		}
		return res;
	}

	private static int countOddNumbers(int[] ar) {
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] % 2 != 0)
				count++;
		}
		return count;
	}

	private static void displayNumbers(String title, int[] oddNumbers) {
		System.out.println("*******************************");
		System.out.println(title);
		System.out.println(Arrays.toString(oddNumbers));
		System.out.println("*******************************");
	}
}
