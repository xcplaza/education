
public class HW_08_while {

	public static void main(String[] args) {
		int number = 1234567890;
		int count = evenDigitsCount(number);
		System.out.println("В числе " + number + " четных цифр " + count);

		int sum = sumDigits(number);
		System.out.println("В числе " + number + " сумма =  " + sum);

		int x = 0;
		int power = -2;
		int result = xPower(x, power);
		System.out.println(x + " в степени " + power + " = " + result);

		int powerAdv = -4;
		if (Double.isNaN(xPowerAdv(x, powerAdv)))
			System.out.println("Result NaN");
		else
			System.out.println("Result not NaN");

		double resultAdv = xPowerAdv(x, powerAdv);
		System.out.println(x + " в степени " + powerAdv + " = " + resultAdv);

	}

	public static int evenDigitsCount(int number) {
		if (number < 0) {
			System.out.println("Number negative");
			return -1;
		}
		int count = 0;
		while (number != 0) {
			int digit = number % 10;
			if (digit % 2 == 0) {
				count++;
			}
			number /= 10;
		}
		return count;
	}

	public static int sumDigits(int number) {
		if (number < 0) {
			System.out.println("Number negative");
			return -1;
		}
		int sum = 0;
		while (number != 0) {
			int digit = number % 10;
			sum = sum + digit;
			number = number / 10;
		}
		return sum;
	}

	public static int xPower(int x, int power) {
		if (power < 0) {
			System.out.println("Number negative");
			return 0; // но на это не ориентируемся
		} else if (power == 0) {
			return 1;
		}
		return x * xPower(x, power - 1);
	}

	public static double xPowerAdv(int x, int power) { // x^-y = 1/x^y
//        double result = 1.0;
//        int power2 = power < 0 ? -power : power;
//        while (power2 > 0) {
//            if (power2 % 2 == 1) {
//                result = result * x;
//            }
//            x = x * x;
//            power2 = power2 > 1 ? power2 / 2 : 0;
//        }
//        return power >= 0 ? result : 1.0 / result;
		if (x == 0 && power < 0) {
			System.out.print("Error. Wrong div");
			return Double.NaN;
		}
		return power < 0 ? 1. / xPower(x, -power) : xPowerAdv(x, power);
	}

}
