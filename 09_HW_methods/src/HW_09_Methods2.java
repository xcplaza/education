
public class HW_09_Methods2 {

	public static void main(String[] args) {
		int number = 1234567890;
//		System.out.println(sumOddDigits(number));

		calculateResult(number);

	}

//	public static int sumOddDigits(int number) {
//		if (number < 0)
//			return -1;
//		int oddSum = 0;
//		int evenSum = 0;
//		int temp; // последняя цифра от числа 1234 ->4 / 123->3 / 12->2 / 1->1/0
//		while (number != 0) {
//			temp = number % 10;
//			if (temp % 2 == 0)
//				evenSum += temp; // 4+2 / evenSum = evenSum + temp
//			else
//				oddSum += temp; // 3+1
//			number /= 10;
//		}
//		return oddSum;
//	}
//
//	public static boolean isLuckyNumber(int number) {
//		if (number < 0) {
//			System.out.println("Wrong number");
//			return false;
//		}
//		int oddSum = 0;
//		int evenSum = 0;
//		int temp;
//		int result = number / 1000 * 100 + number % 100;
//		System.out.println(result);

//		if ((number % 10) == number) {
//			while (number != 0) {
//				temp = number % 10;
//				if (temp % 2 == 0)
//					evenSum += temp; // 2+2
//				else
//					oddSum += temp; // 3+1
//				number /= 10;
//				return true;
//			}
//		} else {
//			if ((number % 100) == number) {
//				
//				

////				
////				
//				System.out.println("Не четное количество цифр");
//				return false;
//			}
//		}
//		return false;
//	}

	public static void calculateResult(int number) {
	    int length = 0;
	    int temp = number;
	    while (temp != 0) {
	        length++;
	        temp /= 10;
	    }

	    int divisor = 1;
	    int i = 0;
	    while (i < length / 2) {
	        divisor *= 10;
	        i++;
	    }
	    int firstHalf = (number / divisor) / 10;
	    System.out.println("Fir = " + firstHalf);
	    int secondHalf = number % divisor;
	    System.out.println("Sec = " + secondHalf);
	    System.out.printf("" + firstHalf + secondHalf);
	}
}
