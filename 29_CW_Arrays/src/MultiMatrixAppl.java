
public class MultiMatrixAppl {
	private static final int SIZE = 8000;

	public static void main(String[] args) {
		int[][] martix = new int[SIZE][SIZE];
		long timestamp = System.currentTimeMillis();
		fillArray(martix);
		System.out.println("Fillarray time =" + (System.currentTimeMillis() - timestamp));
		fillArray2(martix);
		System.out.println("Fillarray Advtime =" + (System.currentTimeMillis() - timestamp));
//		printMatrix(martix);
	}

//	заполняем массив последовательно и потому оптимальнее 
	public static void fillArray(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = i * j;
			}
		}
	}

//	количество итераций меньше - но из-за перепрыгивания с массива на массив получаем ухудшение
	private static void fillArray2(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
//			matrix[i][i] = i * i;
			for (int j = 0; j <= i; j++) {
				matrix[i][j] = matrix[j][i] = i * j;
			}
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
