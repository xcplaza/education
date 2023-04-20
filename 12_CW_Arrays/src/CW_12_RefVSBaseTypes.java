
public class CW_12_RefVSBaseTypes {

	public static void main(String[] args) {
		int a = 5;
		f1(a);
		System.out.println(a);

		int[] ar = new int[5];
		System.out.println(ar[0]);
		f2(ar);
		System.out.println(ar[0]);

		int[] test = null;
		System.out.println(test.length);
	}

	private static void f2(int[] array) {
		array[0] = 100500;

	}

	private static void f1(int a) {
		a = 100500;

	}

}
