import java.util.Arrays;

public class HW_13_Arrays {

	public static void main(String[] args) {

		int[] arr = new int[10];
		int min = -5, max = 5;
		randomArrays(arr, min, max);
		System.out.println("RandomArrays = " + Arrays.toString(arr));
		System.out.println("1. IndexMax = " + searchMax(arr));
		System.out.println();

		int[] arAVG = new int[10];
		int minAVG = 0, maxAVG = 5;
		randomArrays(arAVG, minAVG, maxAVG);
		System.out.println("RandomArraysAVG = " + Arrays.toString(arAVG));
		System.out.println("2. AVG = " + avg(arAVG));
		System.err.println();

		reverseArray(arr);
		System.out.print("3. ReversArrays = " + Arrays.toString(arr));
		System.out.println();

		System.out.println();
		firstLastPosSum(arr);
	}

// random arrays
	public static void randomArrays(int[] arr, int min, int max) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * ((max - min) + 1)) + min;
		}
	}

// 1
	public static int searchMax(int[] arr) {
		if (arr == null) {
			System.out.println("Arrays is null!");
			return -1;
		}
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr[max])
				max = i;
		}
		return max;
	}

// 2
	public static float avg(int[] ar) {
		if (ar == null) {
			System.out.println("Wrong parameters!");
			return -1;
		}
		float average = 0;
		if (ar.length > 0) {
			float sum = 0;
			for (int i = 0; i < ar.length; i++) {
				sum += ar[i];
			}
			average = sum / ar.length;
		}
		return average;
	}

// 3
	public static void reverseArray(int[] ar) {
		if (ar == null) {
			System.out.println("Arrays is null!");
			return;
		}
		int length = ar.length;
		for (int i = 0; i < length / 2; i++) {
			int temp = ar[i];
			ar[i] = ar[length - i - 1];
			ar[length - i - 1] = temp;
		}
	}

// 4
	public static void firstLastPosSum(int[] ar) {
		int firstPositiveIndex = -1;
		int lastPositiveIndex = -1;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] > 0) {
				if (firstPositiveIndex == -1) {
					firstPositiveIndex = i;
				} else {
					lastPositiveIndex = i;
				}
			}
		}
		if (firstPositiveIndex != -1 && lastPositiveIndex != -1) {
			int sum = ar[firstPositiveIndex] + ar[lastPositiveIndex];
			System.out.println("4. SumArrays: " + sum);
		} else {
			System.out.println("4. Arrays is not positive.");
		}
	}
}
