
public class logicOper {

	public static void main(String[] args) {
		int a = 6, b = 7;
		boolean c;

		c = a > 0 || a == 6;
		System.out.println(c);

		c = a < 0 && a == 6;
		System.out.println(c);

		c = a > 0 || (a == 6 && b == 6);
		System.out.println(c);

		c = a != 6 && b != 6 || a > 0;
		System.out.println(c);

//		c = x < 4 && x > -4; negative
//		c = x > 4 || x < -4; positive

	}

}
