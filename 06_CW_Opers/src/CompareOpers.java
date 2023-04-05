
public class CompareOpers {

	public static void main(String[] args) {
//		> < >= <= == !=
		int a = 6, b = 7;
		boolean c;

		c = a > b;
		System.out.printf("%d > %d = %b\n", a, b, c);

		c = a < b;
		System.out.printf("%d < %d = %b\n", a, b, c);

		c = a >= b;
		System.out.printf("%d >= %d = %b\n", a, b, c);
		
		c = a <= b;
		System.out.printf("%d <= %d = %b\n", a, b, c);
		
		c = a == b;
		System.out.printf("%d == %d = %b\n", a, b, c);
		
		c = a != b;
		System.out.printf("%d != %d = %b\n", a, b, c);

	}

}
