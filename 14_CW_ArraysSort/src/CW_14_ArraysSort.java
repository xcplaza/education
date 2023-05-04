
public class CW_14_ArraysSort {

	public static void main(String[] args) {

		int ar[] = new int[25];
		int min = -10, max = 30;
		randomArrays(ar, min, max);
		printArray(ar);
//		selectSort(ar);
		bubbleSort(ar);
		printArray(ar);

	}

//	bubbleSort
	public static void bubbleSort(int[] ar) {
		for (int i = 0; i < ar.length - 1; i++) {
			for (int j = 0; j < ar.length - 1 - i; j++) {
				if (ar[j] > ar[j + 1])
					swap(ar, j, j + 1);
			}
		}
	}

	public static void selectSort(int[] ar) {
		int min, min_i;
		for (int i = 0; i < ar.length - 1; i++) {
			min = ar[i]; // кто минимальный элемет
			min_i = i; // его индекс
			for (int j = i + 1; j < ar.length; j++) {
				if (ar[j] < min) {
					min = ar[j];
					min_i = j;
				}
			}
			if (i != min_i)
				swap(ar, min_i, i);
		}
	}

//	сначала на четные по возрастанию, затем на нечетные по убыванию
	public static void evenFirstAdv2(int[] ar) {

		for (int i = 0; i < ar.length - 1; i++) {
			for (int j = 0; j < ar.length - 1 - i; j++) {
				if (ar[j] > ar[j + 1])
					swap(ar, j, j + 1);
				if (ar[j] % 2 != 0)
					swap(ar, j, j + 1);
			}
		}
	}

//	change elements
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
