
public class HW_09_methods {

	public static void main(String[] args) {
		int number = 1234560;
		System.out.println("sum = " + sumOddDigits(number));

		number = 5;
		System.out.println("fac = " + factorial(number));

		number = 123456;
		printReverseNumber(number);

		number = 12340;
		System.out.println("revers !0 = " + reverseNumber(number));

		number = 1234001234;
		System.out.println("luckyNum = " + isLuckyNumber(number));

	}

//1
	public static int sumOddDigits(int number) {
		if (number < 0) {
			System.out.print("number error / ");
			return -1;
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
	public static int factorial(int number) { // (5!-> 1*2*3*4*5-> 120);
		if (number <= 0) {
			System.out.print("factorial error / ");
			return -1;
		}
		int result = 1;
		int i = 1;
		while (i <= number) {
			result *= i;
			i++;
		}
		return result;
	}

//3
	public static void printReverseNumber(int number) {
		if (number < 0) {
			System.out.println("revers error");
			return;
		}
		int result = 0;
		while (number != 0) {
			result = result * 10 + number % 10;
			number /= 10;
		}
		System.out.println("revers = " + result);
	}

//4
	public static int reverseNumber(int number) {
		if (number < 0 || number % 10 == 0) {
			System.out.print("number end 0! / ");
			return -1;
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
		int digitCount = 0;
		int temp = number;
		while (temp != 0) {
			digitCount++;
			temp /= 10;
		}
		if (digitCount < 10) {
			System.out.print("number error / ");
			return false;
		}
		int half1 = 0;
		int half2 = 0;
		int divisor = 1;
		int count = digitCount / 2;
		while (count > 0) {
			divisor *= 10;
			count--;
		}
		if (digitCount % 2 == 0) {
			half1 = number / divisor;
			half2 = number % divisor;
		} else {
			half1 = number / divisor;
			half2 = number % (divisor * 10);
		}
		int sum1 = 0;
		int sum2 = 0;
		while (half1 != 0) {
			sum1 += half1 % 10;
			half1 /= 10;
		}
		while (half2 != 0) {
			sum2 += half2 % 10;
			half2 /= 10;
		}
		return sum1 == sum2;
	}
}
