
public class CW_15_BinarySearch {

	public static void main(String[] args) {
		int[] ar = new int[30];
		int min = -10, max = 22;
		randomArrays(ar, min, max);
		bubbleSort(ar);
		printArray(ar);
		int value = 12;
		System.out.println("Search index = " + binarySearch(ar, value));

	}

//	only sorted arrays!
	public static int binarySearch(int[] ar, int value) {
		int left = 0;
		int right = ar.length - 1;
		int middle;
		while (left <= right) {
			middle = (right + left) / 2;
			if (ar[middle] == value)
				return middle;
			else if (ar[middle] < value)
				left = middle + 1; // сдвинули левую сторону для поиска в правой половине +1потому что значение по
									// середине тоже проверили
			else
				right = middle - 1; // сдвигаем правую соторну - 1 потому что значение по середине тоже проверили
		}
		return -1;

	}

	public static void bubbleSort(int[] ar) {
		if (ar == null || ar.length == 0) {
			System.out.println("Wrong arrays!");
			return;
		}
		boolean flag;
		for (int i = 0; i < ar.length - 1; i++) {
			flag = true;
			for (int j = 0; j < ar.length - 1 - i; j++) {
				if (ar[j] > ar[j + 1]) {
					swap(ar, j, j + 1);
					flag = false;
				}
			}
			if (flag)
				return;
		}
	}

	private static void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

//	random arrays
	private static void randomArrays(int[] arr, int min, int max) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * ((max - min) + 1)) + min;
		}
	}

//	print arrays
	private static void printArray(int[] ar) {
		for (int i = 0; i < ar.length; i++)
			System.out.print(ar[i] + " ");
		System.out.println();
	}

}
