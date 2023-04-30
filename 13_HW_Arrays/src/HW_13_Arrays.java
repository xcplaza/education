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
		int minAVG = 1, maxAVG = 5;
//		if (minAVG < 0) {
//			System.out.println("Wrong parameters: minAVG!\n");
//		} else {
		randomArrays(arAVG, minAVG, maxAVG);
//		}
		System.out.println("RandomArraysAVG = " + Arrays.toString(arAVG));
		System.out.println("2. AVG = " + avg(arAVG));
		System.out.println();

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
		if (arr == null || arr.length == 0) {
			System.out.println("Arrays is null or empty!");
			return -1;
		}
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[max])
				max = i;
		}
		return max;
	}

// 2

	public static float avg(int[] ar) {
		if (ar == null || ar.length == 0) {
			System.out.println("Arrays is null or empty!");
			return Float.NaN;
		}
		float sum = 0.f;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] <= 0) {
				System.out.println("Wrong parameters: minAVG!\n");
				return Float.NaN;
			}
			sum += ar[i];
		}
		return sum / ar.length;
	}

//	public static float avg(int[] ar) {
//		if (ar == null) {
//			System.out.println("Arrays is null!");
//			return Float.NaN;
//		}
//		float average = 0;
//		if (ar.length > 0) {
//			float sum = 0;
//			for (int i = 0; i < ar.length; i++) {
//				sum += ar[i];
//			}
//			average = sum / ar.length;
//		}
//		return average;
//	}

// 3
	public static void reverseArray(int[] ar) {
		if (ar == null) {
			System.out.println("Arrays is null!");
			return;
		}
		int temp = 0;
		for (int i = 0, j = ar.length - 1; i < j; i++, j--) {
			temp = ar[i];
			ar[i] = ar[j];
			ar[j] = temp;
		}
	}

//	public static void reverseArray(int[] ar) {
//		if (ar == null) {
//			System.out.println("Arrays is null!");
//			return;
//		}
//		int length = ar.length;
//		for (int i = 0; i < length / 2; i++) {
//			int temp = ar[i];
//			ar[i] = ar[length - i - 1];
//			ar[length - i - 1] = temp;
//		}
//	}

// 4
	public static void firstLastPosSum(int[] ar) {
		if (ar == null) {
			System.out.println("Arrays is null!");
			return;
		}
		int firstPos = -1, lastPos = -1;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] > 0) {
				firstPos = ar[i];
				break;
			}
		}
		if (firstPos == -1) {
			System.out.println("No pisitive elements");
			return;
		}
		for (int i = ar.length - 1; i >= 0; i--) {
			if (ar[i] > 0) {
				lastPos = ar[i];
				break;
			}
		}
		System.out.println("Sum elements = " + (firstPos + lastPos));

	}

//	public static void firstLastPosSum(int[] ar) {
//		int firstIndex = -1;
//		int lastIndex = -1;
//		for (int i = 0; i < ar.length; i++) {
//			if (ar[i] > 0) {
//				if (firstIndex == -1) {
//					firstIndex = i;
//				} else {
//					lastIndex = i;
//				}
//			}
//		}
//		if (firstIndex != -1 && lastIndex != -1) {
//			int sum = ar[firstIndex] + ar[lastIndex];
//			System.out.println("4. SumArrays: " + sum);
//		} else {
//			System.out.println("4. Arrays is not positive.");
//		}
//	}
}
