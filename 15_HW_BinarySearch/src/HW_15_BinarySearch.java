import java.security.Principal;

public class HW_15_BinarySearch {

	public static void main(String[] args) {

		int[] ar = new int[10];
		int min = -10, max = 20, number = 5;
		randomArrays(ar, min, max);
		System.out.println("random arrays");
		printArray(ar);
		System.out.println();

		oddFirst(ar);
		System.out.println("// 1 number");
		printArray(ar);
		System.out.println();

//		bubbleSort(ar); // сортировка для проверки
		isSorted(ar);
		System.out.println("// 2 number\n" + isSorted(ar));
		System.out.println();

		bubbleSort(ar); // сортировка для проверки
		printArray(ar);
		System.out.println("// 3 number\n" + searchAdv(ar, number));
		System.out.println();

	}

	/*
	 * 1 Метод принимает неотсортированный массив и должна отсортировать массив так,
	 * чтобы сначала шли нечетные элементы потом четные
	 */
	public static void oddFirst(int[] ar) {
		if (ar == null || ar.length == 0) {
			System.out.print("Wrong arrays!");
			return;
		}
		boolean flag;
		for (int i = 0; i < ar.length - 1; i++) {
			flag = true;
			for (int j = 0; j < ar.length - 1 - i; j++) {
				if (ar[j] % 2 == 0 && ar[j + 1] % 2 != 0) {
					swap(ar, j, j + 1);
					flag = false;
				}
			}
			if (flag)
				return;
		}
	}

	/*
	 * 2 Метод принимает массив и возвращает true если массив отсортирован по
	 * возрастанию и false если не отсортирован
	 */
	public static boolean isSorted(int[] ar) {
		if (ar == null || ar.length == 0) {
			System.out.println("Wrong arrays!");
			return false;
		}
		for (int i = 0; i < ar.length - 1; ++i) {
			if (ar[i] > ar[i + 1])
				return false;
		}
		return true;
	}

	/*
	 * 3 Метод принимает массив и элемент для поиска, возвращает ИНДЕКС элемента,
	 * если элемент был найден в массиве или - 1 если элемент не был найден в
	 * массиве. Для отсортированных в ASC порядке массивов используется алгоритм
	 * бинарного поиска, для неотсортированных обычный поиск
	 */
	public static int searchAdv(int[] ar, int number) {
		if (ar == null | ar.length == 0 || number < 0 || number >= ar.length) {
			System.out.println("Wrong arrays!");
			return -1;
		}
		for (int i = 0; i < ar.length - 1; i++) {
			if (ar[i] < ar[i + 1]) {
				return binarySearch(ar, number);
			}
		}
		return lineSearch(ar, number);
	}

//	binary search
	public static int binarySearch(int[] ar, int value) {
		int left = 0;
		int right = ar.length - 1;
		int middle;
		while (left <= right) {
			middle = (right + left) / 2;
			if (ar[middle] == value)
				return middle;
			else if (ar[middle] < value)
				left = middle + 1;
			else
				right = middle - 1;
		}
		return -1;

	}

//	line search
	public static int lineSearch(int ar[], int number) {
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == number)
				return i;
		}
		return -1;
	}

//	bubble sort
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

//	swap arrays
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
