
public class CW_09_PracticeLoopsAppl {

	public static void main(String[] args) {

		int num = 2;
		System.out.println(isPrimeNumber(num));
		
		num = 1322;
		System.out.println(isLuckyNumber(num));

	}

//	проверка на простые числа
	public static boolean isPrimeNumber(int num) {
		if (num < 2)
			return false;
		int divider = 2;
		int limit = num / 2;
		while (divider <= limit) {
			if (num % divider == 0)
				return false;
			divider++;
		}
		return true;
	}

//	счастливый билет
	public static boolean isLuckyNumber(int number) {
		if (number <= 10)
			return false;
		int oddSum = 0;
		int evenSum = 0;
		int temp; // последняя цифра от числа 1234 ->4 / 123->3 / 12->2 / 1->1/0
		while (number != 0) {
			temp = number % 10;
			if (temp % 2 == 0)
				evenSum += temp; //4+2 / evenSum = evenSum + temp
			else
				oddSum += temp; //3+1
			number /= 10;
		}
		return evenSum==oddSum;
	}

//	принимает 2 более цифр и сумма первой половины цифр = 2й половине, если не четное количество то среднюю  цифру не считаем.
//	12345 - 3 не считаем
//	возвращаем true / false

}
