
public class HW_6_Opers {

	public static void main(String[] args) {
		int a = 24, b = 16, c = -10;
		System.out.println(whoIsMore(a, b));

		System.out.println(isPozitiv(a));

		System.out.println(sumOrSubst(a, b, c));

		int age = 21, hour = 9;
		System.out.println(alcohol(age, hour));
		
		System.out.println(isPozitiv2(a));

	}

	public static double whoIsMore(int a, int b) {
		return a >= b ? a : b;
	}

	public static boolean isPozitiv(int a) {
		return a >= 0 ? true : false;
	}

	public static int sumOrSubst(int a, int b, int c) {
		return c >= 0 ? a + b : a - b;
	}

	public static boolean alcohol(int age, int hour) {
		return age >= 21 && hour >= 10 && hour < 23 ? true : false;
	}

	public static int isPozitiv2(int a) {
		return a > 0 ? 1 : (a == 0 ? 0 : -1);
	}
}
