import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

public class MatrixTests {

	@Test
	public void test() {
		int[][] matrix = { { 10, 20 }, { 7, 5 }, { 1, 2 } };
		/*
		 * [link1] [link2] [10] [7] [20] [5]
		 */
		System.out.println(matrix[0][0]);
		System.out.println(matrix[1][0]);
//		System.out.println(matrix[0][2]);
//		System.out.println(matrix[2][2]);
		int[][] matrix1 = new int[2][5];
		int[] ar1 = matrix1[0];
		System.out.println(ar1.length);
		System.out.println(matrix1.length);
		System.out.println("Length m1= " + matrix1[0].length);
		System.out.println(matrix[matrix.length - 1][matrix[0].length - 1]);
		/*
		 * [link1] [link2] [0] [0] [0] [0] [0] [0] [0] [0] [0] [0] ar1 ->
		 * [0][0][0][0][0]
		 */

		int[][] matrix2 = new int[2][2];
		System.out.println(matrix2[0][0]);
		matrix2[0][0] = 1;
		matrix2[0][1] = 2;
		matrix2[1][0] = 3;
		matrix2[1][1] = 4;
		/*
		 * [link1] [link2] [1] [3] [2] [4]
		 */
		System.out.println(matrix2[0][0]);
		printMatrix(matrix2);
		System.out.println(Arrays.deepToString(matrix2));
		int[][] res = new int[matrix.length + 1][];
//		System.out.println("Test = " + res[0][0]);
		System.out.println("Test = " + Arrays.deepToString(res));
	}

	private void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

	}

	@Test
	public void testMatrixSum() {
		int[][] matrix = { { 1, 1, 1 }, { 1, 1, 1 } };
		assertEquals(6, MatrixUtils.matrixSum(matrix));
	}

	@Test
	public void testMatrixTransp() {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] expected = { { 1, 4 }, { 2, 5 }, { 3, 6 } };
		assertArrayEquals(expected, MatrixUtils.transp(matrix));
	}

	@Test
	public void testMatrixAddColumn() {
		int[][] matrix = { { 10, 20 }, { 7, 5 } };
		int[] columnElements = { 30, 3 };
		int[][] expMatrix = { { 10, 20 }, { 7, 5 }, { 30, 3 } };
		int[][] expMatrix2 = { { 10, 20 }, { 30, 3 }, { 7, 5 } };
		int[][] expMatrix3 = { { 30, 3 }, { 10, 20 }, { 7, 5 } };
		assertArrayEquals(expMatrix3, MatrixUtils.addColumn(matrix, 0, columnElements));
		assertArrayEquals(expMatrix2, MatrixUtils.addColumn(matrix, 1, columnElements));
		assertArrayEquals(expMatrix, MatrixUtils.addColumn(matrix, 2, columnElements));
		/*
		 * matrix [link1] [link2] [10] [7] [20] [5]
		 * 
		 * res [link1] [link2] [link3] [10] [7] [30] [20] [5] [3]
		 */
	}

	@Test
	public void testMatrixAddRow() {
		int[][] matrix = { { 10, 20 }, { 7, 5 } };
		int[] rowElements = { 30, 3 };
		int[][] expMatrix0 = { { 30, 10, 20 }, { 3, 7, 5 } };
		int[][] expMatrix1 = { { 10, 30, 20 }, { 7, 3, 5 } };
		int[][] expMatrix2 = { { 10, 20, 30 }, { 7, 5, 3 } };
		assertArrayEquals(expMatrix0, MatrixUtils.addRow(matrix, 0, rowElements));
		assertArrayEquals(expMatrix1, MatrixUtils.addRow(matrix, 1, rowElements));
		assertArrayEquals(expMatrix2, MatrixUtils.addRow(matrix, 2, rowElements));

	}

	@Test
	public void testMatrixRemoveRow() {
		int[][] matrix = { { 10, 20, 30 }, { 7, 5, 3 } };
		int[][] expMatrix0 = { { 20, 30 }, { 5, 3 } };
		int[][] expMatrix1 = { { 10, 30 }, { 7, 3 } };
		int[][] expMatrix2 = { { 10, 20 }, { 7, 5 } };
		assertArrayEquals(expMatrix0, MatrixUtils.removeRow(matrix, 0));
		assertArrayEquals(expMatrix1, MatrixUtils.removeRow(matrix, 1));
		assertArrayEquals(expMatrix2, MatrixUtils.removeRow(matrix, 2));
	}

	@Test
	public void testMatrixRemoveColumn() {
		int[][] matrix = { { 10, 20, 30 }, { 7, 5, 3 }, { 100, 200, 300 } };
		int[][] expMatrix0 = { { 7, 5, 3 }, { 100, 200, 300 } };
		int[][] expMatrix1 = { { 10, 20, 30 }, { 100, 200, 300 } };
		int[][] expMatrix2 = { { 10, 20, 30 }, { 7, 5, 3 } };
		assertArrayEquals(expMatrix0, MatrixUtils.removeColumn(matrix, 0));
		assertArrayEquals(expMatrix1, MatrixUtils.removeColumn(matrix, 1));
		assertArrayEquals(expMatrix2, MatrixUtils.removeColumn(matrix, 2));
	}
}
