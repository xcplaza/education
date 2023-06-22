
public class MultMatrixAppl {
	private static final int SIZE = 8000;

	public static void main(String[] args) {
		int[][] matrix = new int[SIZE][SIZE];
		long timestamp = System.currentTimeMillis();
		fillArray(matrix);
		System.out.println("fill array time = " + (System.currentTimeMillis()-timestamp));
		timestamp = System.currentTimeMillis();
		fillArray2(matrix);
		System.out.println("fill array advanced time = " + (System.currentTimeMillis()-timestamp));
//		printMatrix(matrix);

	}

	public static void fillArray(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = i * j;
			}
		}
	}

	private static void fillArray2(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
//			matrix[i][i] = i*i;
			for (int j = 0; j <= i; j++) {
				matrix[i][j] = matrix[j][i] = i * j;
			}
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}

}
