
public class HW_12_Arrays {

	public static void main(String[] args) {

		int[] ar = { 1, 2, 3, 4, 9, 0, 1, 2, 5 };
		printArrayReverse(ar);
		System.out.println();

		System.out.println(sumEvenIndexElements(ar) + "\n");

		sumEvenElements(ar);
		System.out.println();

		changeElements(ar);
		System.out.println();

		int[] ar1 = { 1, 2, 3 };
		int[] ar2 = { 4, 5, 6, 7, 8 };
		mergeArrays(ar1, ar2);
	}

//	1 Метод выводит массив на консоль в обратном порядке.
	public static void printArrayReverse(int[] array) {
		if (array == null) {
			System.out.println("Array is null");
			return;
		}
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

//	2 Метод возвращает сумму элементов из четных индексов.
	public static int sumEvenIndexElements(int[] ar) {
		if (ar == null) {
			System.out.println("Array is null");
			return -1;
		}
		int sum = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] % 2 == 0)
				sum += ar[i];
		}
		return sum;
	}

//	3  	Метод возвращает сумму четных элементов. 
	public static void sumEvenElements(int[] ar) {
		if (ar == null) {
			System.out.println("Array is null");
			return;
		}
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] % 2 == 0)
				count++;
		}
		System.out.println(count);
	}

//	4 Метод принимает массив и все четные элементы в нем меняет на 0, а нечетные на 1.  
	public static void changeElements(int[] ar) {
		if (ar == null) {
			System.out.println("Array is null");
			return;
		}
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] % 2 == 0) {
				ar[i] = 0;
			} else {
				ar[i] = 1;
			}
			System.out.print(ar[i] + " ");
		}
		System.out.println();
	}

	/*
	 * 5 метод принимает два массива, и размеры этих массивов, сливает все элементы
	 * в один массив и выводит его на консоль.
	 */
	public static void mergeArrays(int[] ar1, int[] ar2) {
		if (ar1 == null || ar2 == null) {
			System.out.println("Arrays is null");
			return;
		}
		int count = 0;
		int[] ar3 = new int[ar1.length + ar2.length];
		for (int i = 0; i < ar1.length; i++) {
			ar3[i] = ar1[i];
			count++;
		}
		for (int j = 0; j < ar2.length; j++) {
			ar3[count++] = ar2[j];
		}
		for (int x = 0; x < ar3.length; x++) {
			System.out.print(ar3[x] + " ");
		}
	}
}
