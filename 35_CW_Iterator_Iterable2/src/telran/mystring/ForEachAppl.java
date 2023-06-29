package telran.mystring;

public class ForEachAppl {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4, 5, 6 };
		for (Integer n : ar) {
			System.out.println(n + " ");
		}
		System.out.println();
		int sum = 0;
		for (Integer n : ar) {
			sum += n;
		}
		System.out.println(sum);
//		=====================================
		MyString ms = new MyString("Hello");
		for (Character c : ms) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

}
