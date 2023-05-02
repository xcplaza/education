

public class HW_09_methods {

	public static void main(String[] args) {
		int number = 1234560;
		System.out.println("sum = " + sumOddDigits(number));

		number = 0;
		System.out.println(number + "! = " + factorial(number));

		number = 123456;
		printReverseNumber(number);

		number = 1234;
		System.out.println("revers !0 = " + reverseNumber(number));

		number = 3939456;
		System.out.println("luckyNum = " + isLuckyNumber(number));

	}

//1
	public static int sumOddDigits(int number) {
		if (number < 0) {
			System.out.print("number error / ");
			return number;
		}
		int sum = 0;
		while (number != 0) {
			int digit = number % 10;
			if (digit % 2 != 0) {
				sum += digit;
			}
			number /= 10;
		}
		return sum;
	}

//2
//	public static int factorial(int number) {
//		if (number == 0) {
//			return 1;
//		} else if (number < 0 || number > 12) {
//			System.out.print("factorial error / ");
//			return -1;
//		}
//		int result = 1;
//		int i = 1;
//		while (i <= number) {
//			result *= i;
//			i++;
//		}
//		return result;
//	}

	public static int factorial(int number) {
		if (number < 0 || number > 12) {
			System.out.print("factorial error / ");
			return -1;

		}
		int result = 1;
		while (number > 1) {
			result *= number--;
		}
		return result;
	}

//3
//	public static void printReverseNumber(int number) {
//		if (number < 0) {
//			System.out.println("revers error");
//			return;
//		}
//		int result = 0;
//		while (number != 0) {
//			result = result * 10 + number % 10;
//			number /= 10;
//		}
//		System.out.println("revers = " + result);
//	}

	public static void printReverseNumber(int number) {
		if (number < 0) {
			System.out.println("revers error");
			return;
		}
		do {
			System.out.print(number % 10);
			number /= 10;
		} while (number != 0);
		System.out.println();

	}

//4
	public static int reverseNumber(int number) {
		if (number < 0 || number % 10 == 0) {
			System.out.print("number end 0! / ");
			return number;
		}
		int result = 0;
		while (number != 0) {
			result = result * 10 + number % 10;
			number /= 10;
		}
		return result;
	}

//5
	public static boolean isLuckyNumber(int number) {
		if (number <= 10) // количество по значению
			return false;
		int countDigits = countDigits(number);
		int divider = xPower(10, countDigits / 2); // степень числа
		int left = number / divider; // получаем левую часть 1239456 / 1000 = 1239
		if (countDigits % 2 != 0) // если нечетное количество цифр делением убираем полседнюю цифру
			left /= 10;
		int right = number % divider; // получаем правую часть 123456 %1000 = 456
		return sumDigits(left) == sumDigits(right); // сравниваем
	}

	private static int sumDigits(int num) {
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
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

//	public static boolean isLuckyNumber(int number) {
//		int digitCount = 0;
//		int temp = number;
//		while (temp != 0) {
//			digitCount++;
//			temp /= 10;
//		}
//		if (digitCount < 10) {
//			System.out.print("number error / ");
//			return false;
//		}
//		int half1 = 0;
//		int half2 = 0;
//		int divisor = 1;
//		int count = digitCount / 2;
//		while (count > 0) {
//			divisor *= 10;
//			count--;
//		}
//		if (digitCount % 2 == 0) {
//			half1 = number / divisor;
//			half2 = number % divisor;
//		} else {
//			half1 = number / divisor;
//			half2 = number % (divisor * 10);
//		}
//		int sum1 = 0;
//		int sum2 = 0;
//		while (half1 != 0) {
//			sum1 += half1 % 10;
//			half1 /= 10;
//		}
//		while (half2 != 0) {
//			sum2 += half2 % 10;
//			half2 /= 10;
//		}
//		return sum1 == sum2;
//	}
}
