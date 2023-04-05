
public class CW_08_While {
	/*
	 * while (condition) {block; loop step}
	 */
	public static void main(String[] args) {
		int i = 0;
		while (i >= 0) {
			System.out.println(i);
			i = i - 1;
		}
		int num = 0;
		System.out.println("Number cout = " + countDigits(num));

		int stars = 20;
		int col = 4;
		printStars(stars, col);
		
		num =12;
		squares(num);

	}

	public static void squares(int num) {
		if (num <= 0)
			return;

		int temp = 1;
		while (temp <= num) {
			System.out.printf("%d -> %d\n", temp, temp * temp);
			temp = temp + 1;
		}
	}

	public static void printStars(int stars, int column) {
		/*
		 * **** **** **
		 */
		if (stars <= 0 || column <= 0)
			return;
		int count = 0;
		while (stars > 0) {
			System.out.print("* ");
			stars = stars - 1;
			count = count + 1;
			if (count % column == 0)
				System.out.println();
		}

	}

	public static int countDigits(int number) {
		if (number == 0) {
			return 1;
		}
		int count = 0;
		while (number != 0) {
			number = number / 10;
			count = count + 1;
		}
		return count;
	}

}
