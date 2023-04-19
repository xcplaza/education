
public class HW_11_InnerLoops {

	public static void main(String[] args) {

		int from = 66;
		int to = 74;
		print_abc_reverse(from, to);
		System.out.println();

		int number = 2;
		char letter = 'a';
		chessBoard(number, letter);

		int size = 11;
//		squareEmpty(size);

		System.out.println();
		square(size);

		System.out.println();
		traingleEmpty3(size);

		System.out.println();
		traingleEmpty(size);

		System.out.println();
		traingleEmpty2(size);

	}

//	1
	public static void print_abc_reverse(int from, int to) {
		if (from < 32 || to > 126 || from > to) {
			System.out.println("Wrong args");
			return;
		}
		int count = 0;
		for (int i = to; i >= from; i--) {
			System.out.print((char) i + " ");
			count++;
			if (count == 3) {
				System.out.println();
				count = 0;
			}
		}
	}

//	2
	public static void chessBoard(int number, char letter) {
		if (number <= 0 || number > 8 || letter < 97 || letter > 104) {
			System.out.println("Wrong args");
			return;
		}
		if ((number % 2 == 0 && letter % 2 == 0) || (number % 2 != 0 && letter % 2 != 0)) {
			System.out.println("Black");
		} else {
			System.out.println("White");
		}

	}

//	3
	public static void square(int size) {
		sandglassUp(size);
		System.out.println();

		sandglassDown(size);
		System.out.println();

	}

	public static void sandglassUp(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (i == 1 || i == size || j == 1 || j == size || i == j || i + j == size + 1
						|| (j > i && i + j < size + 1))
					System.out.print("* ");
				else
					System.out.print("  ");

			}
			System.out.println();
		}
	}

	public static void sandglassDown(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (i == 1 || i == size || j == 1 || j == size || i == j || i + j == size + 1
						|| (j < i && i + j > size + 1))
					System.out.print("* ");
				else
					System.out.print("  ");

			}
			System.out.println();
		}
	}

//	public static void sandglassUp(int size) {
//		for (int i = 1; i <= size; i++) {
//			for (int j = 1; j <= size; j++) {
//				if (i == 1 || i == size || j == 1 || j == size || i == j|| i + j == size + 1|| j > i && j <= size - i)
//					System.out.print("* ");
//				else
//					System.out.print("  ");
//			}
//			System.out.println();
//		}
//	}

	public static void traingleEmpty(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (j == 1 || i == size || i == j) {
					System.out.print("* ");
				} else
					System.out.print("  ");

			}
			System.out.println();
		}
	}

	public static void traingleEmpty2(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (i == 1 || j == size || i == j) {
					System.out.print("* ");
				} else
					System.out.print("  ");

			}
			System.out.println();
		}
	}

	public static void traingleEmpty3(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void traingleEmpty4(int size) {
		for (int j = 1; j <= size; j++) {
			for (int i = 1; i <= size + j; j++) {
				System.out.print(" ");
			}
			for (int i = 1; i <= i * 2 + 1; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
