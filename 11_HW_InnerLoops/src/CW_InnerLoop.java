
public class CW_InnerLoop {

	public static void main(String[] args) {
		for (int a = 0; a < 5; a++) {
			for (int b = 0; b < 5; b++) {
				System.out.println("a = " + a + " , b = " + b);
			}
		}

		int size = 21;
		square(size);
		squareEmpty(size);

	}

	public static void square(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	/*
	 * i == 1 - ячейка на верхней границе квадрата (первая строка) 
	 * i == size - ячейка на нижней границе квадрата (последняя строка) 
	 * j == 1 - ячейка на левой границе квадрата (первый столбец) 
	 * j == size - ячейка на правой границе квадрата (последний столбец) 
	 * i == j - ячейка на диагонали квадрата (при этом это необходимо только для i > 1 и i < size, 
	 * чтобы избежать дублирования звездочек в углах квадрата)
	 */

	public static void squareEmpty(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (i == 1 || i == size || j == 1 || j == size || i == j)
					System.out.print("* ");
				else
					System.out.print("  ");

			}
			System.out.println();
		}
	}

}
