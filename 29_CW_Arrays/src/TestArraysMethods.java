import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.Test;

public class TestArraysMethods {

	@Test
	public void test() {
		int[] ar = new int[3];
		ar[0] = 10;
		ar[1] = -100;
		ar[2] = 5;
		assertEquals(-100, ar[1]);

		int[] ar1 = { 10, 5, 7 };
		int[] ar2 = ar1;
		assertTrue(ar1 == ar2);
		int[] ar3 = { 10, 5, 7 };
//		assertTrue(ar1 == ar3);
		assertFalse(ar1 == ar3);
		assertArrayEquals(ar1, ar3);
		System.out.println(Arrays.toString(ar1));
		Arrays.sort(ar1);
		System.out.println(Arrays.toString(ar1));
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar));
		System.out.println(Arrays.binarySearch(ar, 5));
		System.out.println(Arrays.binarySearch(ar, 6)); // возвращает отрицательное значение гипотетического
														// расположения числа 6 (между 5 и 10) и добавляет -1 чтобы не
														// учитывать 0 [-100 5 6 10]
		System.out.println(Arrays.binarySearch(ar, -101));
		int ar4[] = Arrays.copyOf(ar1, ar1.length);
		System.out.println(Arrays.toString(ar4));
		assertFalse(ar1 == ar4);
		ar4 = Arrays.copyOf(ar1, ar1.length + 1);
		System.out.println(Arrays.toString(ar4));
		ar4 = Arrays.copyOf(ar1, ar1.length - 1);
		System.out.println(Arrays.toString(ar4));
//		ar4 = Arrays.copyOf(ar1, ar1.length - 100); //нельзя выйти за пределы массива
//		ar4 = Arrays.copyOf(ar1, ar1.length - 3);
		System.out.println(Arrays.toString(ar4));
		int[] ar5 = new int[3];
		System.arraycopy(ar1, 0, ar5, 0, ar1.length); // 5 аргументов: /1 - откуда копируем /2 - с какой позиции
														// копируем /3 - в
		// какой массив /4 - в какую позицию пишем (начало) /5 - сколько
		// элементов перенести
	}

	@Test
	public void testAddatEnd() {
		int ar[] = { 10, 2, 7 };
		int num = 100;
		int[] exp = { 10, 2, 7, num };
		assertArrayEquals(exp, ArraysUtils.add(ar, num));
	}

	@Test
	public void testAddAtIndex() {
		int[] ar = { 10, 2, 7 };
		int num = 100;
		int[] exp = { 10, num, 2, 7 };
		int index = 1;
		assertArrayEquals(exp, ArraysUtils.add(ar, num, index));
	}

	@Test
	public void testRemoveLast() {
		int[] ar = { 10, 2, 7 };
		int[] exp = { 10, 2 };
		assertArrayEquals(exp, ArraysUtils.remove(ar));
	}

	@Test
	public void testRemoveAtIndex() {
		int[] ar = { 10, 2, 7 };
		int[] exp = { 10, 7 };
		int index = 1;
		assertArrayEquals(exp, ArraysUtils.remove(ar, index));
	}
	
//	========================= MATRIX =========================//
}
