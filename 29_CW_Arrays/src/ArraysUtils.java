import java.util.Arrays;

public class ArraysUtils {

	public static int[] add(int[] ar, int num) {
		if (ar == null)
			return null;
		int[] res = Arrays.copyOf(ar, ar.length + 1);
		res[ar.length] = num;
//		res[res.length-1] = num; или так s
		return res;
	}

	public static int[] add(int[] ar, int num, int index) {
		if (ar == null)
			return null;
		if (index < 0 || index >= ar.length)
			return ar;
		int[] res = new int[ar.length + 1];
		System.arraycopy(ar, 0, res, 0, index); // index - потому что равен числу элементов (1)
		res[index] = num;
		System.arraycopy(ar, 1, res, 2, ar.length - index); // ar.length - index / длинна массива минус 1 (index=1)
		return res;
	}

	public static int[] remove(int[] ar) {
		if (ar == null || ar.length == 0)
			return ar;
		return Arrays.copyOf(ar, ar.length - 1);
	}

	public static int[] remove(int[] ar, int index) {
		if (ar == null || ar.length == 0 || index < 0 || index >= ar.length)
			return ar;
		int[] res = new int[ar.length - 1];
		System.arraycopy(ar, 0, res, 0, index); // index - потому что равен числу элементов (1)
		System.arraycopy(ar, 2, res, 1, res.length - index); // ar.length - index / длинна массива минус 1 (index=1)
		return res;
	}

}
