
public class CW_InnerLoops {

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

	public static void squareEmpty(int size) {
		for (int i = 1; i <= size; i++) {
			for(int j = 1; j<=size; j++) {
				if (i ==1 || i == size || j == 1 || j == size || i == j) 
				System.out.print("* ");
				else 
					System.out.print("  ");
				
			}
			System.out.println();
		}
	}

}
