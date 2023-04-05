
public class CW_09_Do_While {

	public static void main(String[] args) {

		int i = 5;
		while (i != 5) {
			System.out.println("Hello");
		}
		do {
			System.out.println("Hello i am do while");
		} while (i != 5);

		i = 5;
		System.out.println("EDC = " + evenDigitsCount(i));
	}

	public static int evenDigitsCount(int number) {
		int count = 0;
		do {
			if (number % 2 == 0)
				count++;
			number /= 10;
		} while (number != 0);
		return count;
	}

}
