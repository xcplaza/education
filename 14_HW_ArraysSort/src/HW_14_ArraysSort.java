public class HW_14_ArraysSort {

	public static void main(String[] args) {
		int ar[] = new int[15];
		int min = -10, max = 30;
		System.out.println("// random arrays");
		randomArrays(ar, min, max);
		printArray(ar);
		System.out.println();

		System.out.println("// number 1");
		sortReverse(ar);
		printArray(ar);
		System.out.println();

		int start = 0, finish = 3;
		sortInRange(ar, start, finish);
		System.out.println("// number 2");
		printArray(ar);
		System.out.println();

		System.out.println("// number 3");
		evenFirst(ar);
		printArray(ar);
		System.out.println();

		System.out.println("// number 4");
		evenFirstAdv(ar);
		printArray(ar);

	}

	/*
	 * 1 метод принимает массив и сортирует в порядке убывания.
	 */
	public static void sortReverse(int[] ar) {
		if (ar == null)
			return;
		boolean flag;
		for (int i = 0; i < ar.length - 1; i++) {
			flag = true;
			for (int j = 0; j < ar.length - 1 - i; j++) {
				if (ar[j] < ar[j + 1]) {
					swap(ar, j, j + 1);
					flag = false;
				}
			}
			if (flag) // если он true - заходим в 2й цикл, если нет - не заходим в цикл
				return;
		}
	}

	/*
	 * 2 метод принимает массив и сортирует в порядке возрастания только часть
	 * массива в диапазоне от start включительно до finish включительно(start и
	 * finish индексы). Остальная часть массива остается без изменений.
	 */
	static public void sortInRange(int[] ar, int start, int finish) {
		if (ar == null || start < 0 || start >= ar.length - 1 || finish < 0 || finish >= ar.length || start > finish) {
			System.out.println("Wrong input!");
			return;
		}
		for (int i = start; i <= finish; i++) {
			int min = ar[i];
			int min_i = i;
			for (int j = i + 1; j <= finish; j++) {
				if (ar[j] < min) {
					min = ar[j];
					min_i = j;
				}
			}
			if (i != min_i)
				swap(ar, min_i, i);
		}
	}

	/*
	 * 3 метод принимает массив и сортирует сначала на четные, затем идут нечетные
	 * значения.
	 */
	public static void evenFirst(int[] ar) {
		if (ar == null)
			return;
		for (int i = 0; i < ar.length - 1; i++) {
			for (int j = 0; j < ar.length - 1 - i; j++) {
				if (ar[j] % 2 != 0 && ar[j + 1] % 2 == 0)
					swap(ar, j, j + 1);
			}
		}
	}

	/*
	 * 4 метод принимает массив и сортирует сначала на четные по возрстанию, затем
	 * идут нечетные значения по убыванию.
	 */
	public static void evenFirstAdv(int[] ar) {
		if (ar == null)
			return;
		for (int i = 0; i < ar.length - 1; i++) {
			for (int j = 0; j < ar.length - 1 - i; j++) {
				if (ar[j] % 2 == 0 && ar[j + 1] % 2 == 0 && ar[j] > ar[j + 1])
					swap(ar, j, j + 1);
				else if (ar[j] % 2 != 0 && ar[j + 1] % 2 != 0 && ar[j] < ar[j + 1])
					swap(ar, j, j + 1);
				else if (ar[j] % 2 != 0 && ar[j + 1] % 2 == 0)
					swap(ar, j, j + 1);
			}
		}
	}

//	change elements
//	1 2 3 4		temp = 1
	private static void swap(int[] ar, int i, int j) {
		int temp = ar[i]; 	// temp = 1
		ar[i] = ar[j]; 		// 4 -> 1
		ar[j] = temp; 		// temp -> 1
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
