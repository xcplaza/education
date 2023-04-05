
public class HW_09_methods {

	public static void main(String[] args) {
		int number = 1234560;
		System.out.println("sum = " + sumOddDigits(number));
		
		number = 5;
		System.out.println("fac = " + factorial(number));

		number = 1203;
		printReverseNumber(number);

		number = 12340;
		System.out.println("revers!0 = " + reverseNumber(number));

		number = 12340;
		System.out.println("luckyNum = " + isLuckyNumber(number));

	}

//1
	public static int sumOddDigits(int number) {
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
		if (number == 0) {
			return 1;
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
			System.out.print ("number end 0! / ");
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

		// считаем количество цифр в числе
		while (temp > 0) {
			temp /= 10;
			digitCount++;
		}

		// исключаем цифру посередине, если число имеет нечетное количество цифр
		boolean excludeMiddle = false;
		if (digitCount % 2 != 0) {
			excludeMiddle = true;
		}

		// вычисляем сумму первой половины числа
		int halfSum = 0;
		int power = 1;
		int digit;
		while (number > 0) {
			digit = number % 10;
			if (excludeMiddle && power == (digitCount / 2) + 1) {
				// исключаем цифру посередине, если число имеет нечетное количество цифр
				excludeMiddle = false;
			} else if (power <= digitCount / 2) {
				halfSum += digit;
			}
			number /= 10;
			power *= 10;
		}

		// вычисляем сумму второй половины числа
		int secondHalfSum = (digitCount % 2 == 0) ? halfSum : 0; // если количество цифр четное, вторая половина
																	// суммируется сразу же
		number = number * power / 10; // восстанавливаем число, отбросив последнюю цифру
		power = 1;
		while (number > 0) {
			digit = number % 10;
			if (power > digitCount / 2) {
				secondHalfSum += digit;
			}
			number /= 10;
			power *= 10;
		}

		// проверяем равенство сумм половин числа
		return halfSum == secondHalfSum;
	}

}
