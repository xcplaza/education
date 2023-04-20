
public class CW_12_Arrays {

	public static void main(String[] args) {
//		option 1
//		min index =0, max index lenght -1
//		indexes      0  1  2  3  4  5  6  7  8 
		int[] ar = { 1, 2, 3, 4, 9, 0, 1, 2, 5 };
		System.out.println(ar[0]);

		prinArray(ar);

//		option 2
		int[] ar2 = new int[10];
		prinArray(ar2);
		
		boolean[] ar3 = new boolean[5];
		System.out.println(ar3[2]);
		ar3[2] = true;
		System.out.println(ar3[2]);
		
		printOddElements(ar);

	}
	
	public static void printOddElements (int[] array) {
		if (array == null) {
			System.out.println("Array is null");
			return;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 !=0)
				System.out.print(array[i] + " ");
		}
		System.out.println();
	}

//	выводим массив в консоль
	public static void prinArray(int[] array) {
		if (array == null) {
			System.out.println("Array is null");
			return;
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
