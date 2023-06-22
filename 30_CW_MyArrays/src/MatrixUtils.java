
public class MatrixUtils {

	public static long matrixSum(int[][] matrix) {
		long res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				res += matrix[i][j];
			}
		}
		return res;
	}

	public static int[][] transp(int[][] matrix) {
		int[][] res = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				res[j][i] = matrix[i][j];
			}
		}
		return res;
	}

	public static int[][] addColumn(int[][] matrix, int index, int[] columnElements) {
		if (matrix == null || matrix[0].length != columnElements.length)
			return null;
		if (index < 0 || index > matrix.length)
			return matrix;
		int[][] res = new int[matrix.length + 1][];
		System.arraycopy(matrix, 0, res, 0, index);
		res[index] = columnElements;
		System.arraycopy(matrix, index, res, index + 1, matrix.length - index);
		return res;

	}

	public static int[][] addRow(int[][] matrix, int index, int[] rowElements) {
		if (matrix == null || rowElements == null || rowElements.length != matrix.length)
			return null;
		if (index < 0 || index > matrix[0].length)
			return matrix;
		int[][] res = new int[matrix.length][];
		for (int i = 0; i < res.length; i++) {
			res[i] = add(matrix[i], rowElements[i], index);
		}
		return res;
	}

	private static int[] add(int[] ar, int num, int index) {
		if (ar == null)
			return null;
		else if (index < 0 || index > ar.length)
			return ar;
		int[] res = new int[ar.length + 1];
		System.arraycopy(ar, 0, res, 0, index);
		res[index] = num;
		System.arraycopy(ar, index, res, index + 1, ar.length - index);
		return res;
	}

	public static int[][] removeRow(int[][] matrix, int index) {
		if (matrix == null || index < 0 || index >= matrix[0].length)
			return matrix;
		int[][] res = new int[matrix.length][];
		for (int i = 0; i < res.length; i++) {
			res[i] = remove(matrix[i], index);
		}

		return res;
	}

	private static int[] remove(int[] ar, int index) {
		if (ar == null || ar.length == 0 || index < 0 || index >= ar.length)
			return ar;
		int[] res = new int[ar.length - 1];
		System.arraycopy(ar, 0, res, 0, index);
		System.arraycopy(ar, index + 1, res, index, ar.length - index - 1);
		return res;
	}

	public static int[][] removeColumn(int[][] matrix, int index) {
		if (matrix == null || index < 0 || index >= matrix.length)
			return matrix;
		int[][] res = new int[matrix.length - 1][];
		System.arraycopy(matrix, 0, res, 0, index);
		System.arraycopy(matrix, index + 1, res, index, matrix.length - index - 1);
		return res;
	}

}
