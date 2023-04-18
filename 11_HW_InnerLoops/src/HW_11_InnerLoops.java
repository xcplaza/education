
public class HW_11_InnerLoops {

	public static void main(String[] args) {

		int from = 66;
		int to = 74;
		print_abc_reverse(from, to);

		int number = 8;
		char letter = 'h';
		chessBoard(number, letter);

		int size = 10;
		squareEmpty(size);
		System.out.println("");
		traingleEmpty(size);

		System.out.println();
		traingleEmpty2(size);

		System.out.println();
		traingleEmpty3(size);

		System.out.println();
		traingleEmpty(size);

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
	public static void squareEmpty(int size) {
	    for (int i = 1; i <= size; i++) {
	        for (int j = 1; j <= size; j++) {
	            if (i == 1 || i == size || j == 1 || j == size) {
	                System.out.print("* ");
	            } else if (i <= size / 2 + 1) {
	                if (j == i || j == size - i + 1) {
	                    sandglassUp(size / 2 + 1 - i, size / 2 + 1);
	                } else {
	                    System.out.print("  ");
	                }
	            } else {
	                if (j == i - size / 2 || j == size - i + size / 2) {
	                    sandglassDown(i - size / 2 - 1, size / 2 + 1);
	                } else {
	                    System.out.print("  ");
	                }
	            }
	        }
	        System.out.println();
	    }
	}

	public static void sandglassUp(int i, int size) {
	    for (int k = 1; k <= i; k++) {
	        System.out.print("  ");
	    }
	    for (int k = 1; k <= size - 2 * i; k++) {
	        System.out.print("* ");
	    }
	}

	public static void sandglassDown(int i, int size) {
	    for (int k = 1; k <= size / 2 - i; k++) {
	        System.out.print("  ");
	    }
	    for (int k = 1; k <= 2 * i + 1; k++) {
	        System.out.print("* ");
	    }
	    for (int k = 1; k <= size / 2 - i; k++) {
	        System.out.print("  ");
	    }
	}

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
