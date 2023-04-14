
public class CW_10_ForInr {

	public static void main(String[] args) {
		int a;
		for (a = 0; a < 5; a++) {
			System.out.print(a + " ");
		}
		System.out.println();
		//=============================
		a = 0;
		for (; a < 5; a++) {
			System.out.print(a + " ");
		}
		System.out.println();
		//=============================
		a = 0;
		for (; a < 5;) {
			System.out.print(a + " ");
			a++;
		}
		System.out.println();
		//=============================
		a = 0;
		for (;;) {
			System.out.print(a + " ");
			a++;
			if (a == 5)
				break;
		}
		System.out.println();
		//=============================
		for (int c = 1, b = 0; c <= 10 && b <= 100; c++, b += 10) {
			System.out.println("c = " + c + ", b = " + b);
		}
		// =============================
		a = 123456;
		System.out.println(a + " -> " + backOrder(a));

		// =============================
		int num = 12345, digit = 4;
		System.out.println(hasDigit(num, digit));

		// ============================= ищем число 56 в num
		digit = 34;
		System.out.println(hasSubNumber(num, digit));

	}

	public static int backOrder(int num) {
		if (num < 0 || num % 10 == 0) {
			System.out.print("number end 0! / ");
			return num;
		}
		int res;
		for (res = 0; num != 0; num /= 10) {
			res = res * 10 + num % 10;
		}
		return res;
	}

	public static boolean hasDigit(int num, int digit) {
		if (num < 0 || digit < 0 || digit > 9) {
			System.out.println("wrong args");
			return false;
		}
		do {
			if (num % 10 == digit)
				return true;
			num /= 10;
		} while (num != 0);
		return false;
	}

	public static boolean hasSubNumber(int num, int subNum) { // 1234567 sub=56
		if (num < 0 || subNum < 0 || subNum > num) {
			System.out.print("number end 0! / ");
			return false;
		}

		int dCount = countDigits(subNum);
		int divider = xPower(10, dCount);

		do {
			if (num % divider == subNum)
				return true;
			num /= 10;
		} while (num != 0);
		return false;
	}

	private static int countDigits(int num) {
		int count = 0;
		do {
			count++;
			num /= 10;
		} while (num != 0);
		return count;
	}

	private static int xPower(int x, int power) {
		int res = 1;
		while (power > 0) {
			res *= x;
			power--;
		}
		return res;
	}

}
