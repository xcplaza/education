
public class HW_10_Numbers {

	public static void main(String[] args) {
		int number = 1340536340;
		System.out.println("luckyNum = " + isLuckyNumberPiter(number));
		System.out.println("LuckyNum = " + isLuckyNumberPiter2(number));

		int subNumber = 340;
		System.out.println("Number = " + number + " SubNumber = " + subNumber + " Count = " + countSubNumber(number, subNumber));
		System.out.println("Number = " + number + " SubNumber = " + subNumber + " Count = " + countSubNumber2(number, subNumber));

	}

//	1 Если сумма четных ПО ЗНАЧЕНИЮ цифр равна сумме не четных ПО ЗНАЧЕНИЮ цифр то метод возвращает true
	public static boolean isLuckyNumberPiter(int number) {
		if (number < 10) {
			return false;
		}
		int oddNum = 0;
		int eveNum = 0;
		int temp;
		while (number != 0) {
			temp = number % 10;
			if (number % 2 == 0) {
				eveNum += temp;
			} else
				oddNum += temp;
			number /= 10;
		}
		return eveNum == oddNum;
	}
//1_1
	public static boolean isLuckyNumberPiter2(int number) {
		if (number <= 10) {
			return false;
		}
		int res = 0, temp;
		for (; number != 0; number /= 10) {
			temp = number % 10;
			if (temp % 2 == 0) {
				res += temp;
			} else
				res -= temp;
		}
		return res == 0;
	}

//	2 Возвращает сколько раз суб число в числе встречается или возвращает 0 если не найдено
	public static int countSubNumber(int number, int subNumber) {
		if (subNumber < 0 || subNumber > number) {
			System.out.println("Wrong number or subNumber");
			return -1;
		}
		int count = 0;
		int subNumberDig = countDigits(subNumber);
		if (subNumber == 0) {
			while (number > 0) {
				if (number % 10 == 0) {
					count++;
				}
				number /= 10;
			}
		} else {
			while (number > 0) {
				int current = number % xPower(10, subNumberDig);
				if (current == subNumber) {
					count++;
				}
				number /= 10;
			}
		}
		return count;
	}
	
//	2_2
	public static int countSubNumber2(int number, int subNumber) {
		if (subNumber < 0 || subNumber > number) {
			System.out.println("Wrong number or subNumber");
			return -1;
		}
		int dCount = countDigits (subNumber);
		int divider = xPower(10, dCount);
		int count = 0;
		do {
			if (number % divider == subNumber)
				count++;
			number /=10;
		} while (number !=10);
		return count;
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