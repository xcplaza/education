import java.util.Arrays;

public class CW_13_RandomArrays {

	public static void main(String[] args) {
		System.out.println(Math.random());
		int res = (int) (Math.random() * 10);
		System.out.println(res);
		res = (int) (Math.random() * 100);
		System.out.println(res);
		
		int[] ar = new int[30];
		int min = -5, max = 5;
		fillArray(ar, min, max);
		System.out.println(Arrays.toString(ar));
	}

//	генерация случайных чисел с заполнением массива
	public static void fillArray(int[] ar, int min, int max) {
		for (int i = 0; i < ar.length; i++) {
			ar[i] = (int) (Math.random() *((max - min) + 1)) + min; // +1- чтобы входило max / + min - чтобы входило min значение
		}
	}
	
	

}
