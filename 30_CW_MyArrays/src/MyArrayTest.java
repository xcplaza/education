import static org.junit.Assert.*;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.junit.Before;
import org.junit.Test;

public class MyArrayTest {
	IList numbers;
	IList strings;
	Integer[] arNumbers = { 10, 7, 11, -2, 13, 10, 2000 };
	String[] arStrings = { "abc", "lmn", "fg", "abc" };

	@Before
	public void setUp() throws Exception {
		numbers = new MyArray(1);
		for (int i = 0; i < arNumbers.length; i++) {
			numbers.add(arNumbers[i]);
		}
		strings = new MyArray();
		for (int i = 0; i < arStrings.length; i++) {
			strings.add(arStrings[i]);
		}
	}

	@Test
	public void testSetUp() {
		int sizeNumbers = numbers.size();
		int sizeStrings = strings.size();
		assertEquals(arNumbers.length, sizeNumbers);
		assertEquals(arStrings.length, sizeStrings);
		for (int i = 0; i < sizeNumbers; i++) {
			assertEquals(arNumbers[i], numbers.get(i));
		}
		for (int i = 0; i < sizeStrings; i++) {
			assertEquals(arStrings[i], strings.get(i));
		}
	}

	@Test
	public void testAddToIndex() {
		Integer[] exp = { 100, 10, 7, 11, -2, 13, 10, 2000 };
		assertTrue(numbers.add(0, 100));
		for (int i = 0; i < numbers.size(); i++) {
			assertEquals(exp[i], numbers.get(i));
		}

		Integer[] exp1 = { 100, 10, 7, 100, 11, -2, 13, 10, 2000 };
		assertTrue(numbers.add(3, 100));
		for (int i = 0; i < numbers.size(); i++) {
			assertEquals(exp1[i], numbers.get(i));
		}

		Integer[] exp2 = { 100, 10, 7, 100, 11, -2, 13, 10, 2000, 100 };
		assertTrue(numbers.add(numbers.size(), 100));
		for (int i = 0; i < numbers.size(); i++) {
			assertEquals(exp2[i], numbers.get(i));
		}

		assertFalse(numbers.add(-1, 100));
		assertFalse(numbers.add(numbers.size() + 1, 100));
		assertFalse(numbers.add(1, null));
	}

//	Integer[] arNumbers = { 10, 7, 11, -2, 13, 10, 2000 };
//	String[] arStrings = { "abc", "lmn", "fg", "abc" };
	@Test
	public void testIndex() {
		assertEquals(0, numbers.indexOf(10));
		assertEquals(-1, numbers.indexOf(100));
		assertEquals(-1, numbers.indexOf(null));
		assertEquals(6, numbers.indexOf(2000));
		String str = new String("abc");
		assertEquals(0, strings.indexOf(str));
		assertEquals(-1, strings.indexOf("abca"));
		assertEquals(-1, strings.indexOf(null));
	}

	@Test
	public void testLastIndexOf() {
		assertEquals(5, numbers.lastInsdexOf(10));
		assertEquals(-1, numbers.lastInsdexOf(100));
		assertEquals(-1, numbers.lastInsdexOf(null));

		assertEquals(3, strings.lastInsdexOf("abc"));
		assertEquals(-1, strings.lastInsdexOf("abca"));
		assertEquals(-1, strings.lastInsdexOf(null));
	}

	@Test
	public void testContains() {
		assertTrue(numbers.contains(10));
		assertFalse(numbers.contains(100));
		assertFalse(numbers.contains(null));

		assertTrue(strings.contains("abc"));
		assertFalse(strings.contains("aaa"));
		assertFalse(strings.contains(null));
	}

	@Test
	public void testRemoveAtIndex() {
		Integer[] exp = { 10, 7, -2, 13, 10, 2000 };
		assertEquals(11, numbers.remove(2));
		assertEquals(null, numbers.remove(100));
		assertEquals(null, numbers.remove(-1));
		for (int i = 0; i < numbers.size(); i++) {
			assertEquals(exp[i], numbers.get(i));
		}
	}

	@Test
	public void testRemoveObject() {
		String[] exp = { "lmn", "fg", "abc" };
		assertTrue(strings.remove("abc"));
		for (int i = 0; i < strings.size(); i++) {
			assertEquals(exp[i], strings.get(i));
		}
		Integer[] exp1 = { 10, 7, -2, 13, 10, 2000 };
		assertTrue(numbers.remove((Integer) 11));
		for (int i = 0; i < numbers.size(); i++) {
			assertEquals(exp1[i], numbers.get(i));
		}
	}

	@Test
	public void testToArrayString() {
		assertArrayEquals(arNumbers, numbers.toArray());
		assertArrayEquals(arStrings, strings.toArray());
	}

}
