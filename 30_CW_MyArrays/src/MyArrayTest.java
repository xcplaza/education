import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MyArrayTest {
	IList<Integer> numbers;
	IList<String> strings;
	Integer[] arNumbers = { 10, 7, 11, -2, 13, 10, 2000 };
	String[] arStrings = { "abc", "lmn", "fg", "abc" };

	MyArray<Integer> other;
	Integer[] arOther = { 1, 2, 3, 4 };

	@Before
	public void setUp() throws Exception {
		numbers = new MyArray<Integer>(1);
		for (int i = 0; i < arNumbers.length; i++) {
			numbers.add(arNumbers[i]);
		}
		strings = new MyArray<String>();
		for (int i = 0; i < arStrings.length; i++) {
			strings.add(arStrings[i]);
		}
		other = new MyArray<Integer>();
		for (int i = 0; i < arOther.length; i++) {
			other.add(arOther[i]);
		}
	}

	@Test
	public void testIterable() {
		int ind = 0;
		for (Integer n : numbers) {
			assertEquals(arNumbers[ind++], n);
		}
		assertTrue(ind == arNumbers.length);
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

	@Test
	public void testIndexOf() {
		assertEquals(0, numbers.indexOf(10));
		assertEquals(-1, numbers.indexOf(100));
		assertEquals(-1, numbers.indexOf((Integer) null));
		assertEquals(6, numbers.indexOf(2000));
		String str = new String("abc");
		assertEquals(0, strings.indexOf(str));
		assertEquals(-1, strings.indexOf("abca"));
		assertEquals(-1, strings.indexOf((String) null));
	}

	@Test
	public void testLastIndexOf() {
		assertEquals(5, numbers.lastIndexOf(10));
		assertEquals(-1, numbers.lastIndexOf(100));
		assertEquals(-1, numbers.lastIndexOf((Integer) null));

		assertEquals(3, strings.lastIndexOf("abc"));
		assertEquals(-1, strings.lastIndexOf("abca"));
		assertEquals(-1, strings.lastIndexOf((String) null));
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
		assertEquals((Integer) 11, numbers.remove(2));
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
	public void testToArray() {
		assertArrayEquals(arNumbers, numbers.toArray());
		assertArrayEquals(strings.toArray(), arStrings);
	}

	@Test
	public void testAddAll() {
		Integer[] arExpected = { 10, 7, 11, -2, 13, 10, 2000, 1, 2, 3, 4 };
		numbers.addAll(other);
		assertArrayEquals(arExpected, numbers.toArray());
	}

	@Test
	public void testAddAllAtIndex() {
		Integer[] arExpected = { 10, 7, 1, 2, 3, 4, 11, -2, 13, 10, 2000 };
		numbers.addAll(2, other);
		assertArrayEquals(arExpected, numbers.toArray());
	}

	@Test
	public void testRemoveAll() {
		String[] exp = { "lmn", "fg" };
		assertTrue(strings.removeAll("abc"));
		for (int i = 0; i < strings.size(); i++) {
			assertEquals(exp[i], strings.get(i));
		}
		Integer[] exp1 = { 7, 11, -2, 13, 2000 };
		assertTrue(numbers.removeAll(10));
		for (int i = 0; i < numbers.size(); i++) {
			assertEquals(exp1[i], numbers.get(i));
		}
	}

	@Test
	public void testRemoveAll2() {
		Integer[] arNumbers2 = { 10, 7, 11, -2, 13, 10, 10, 2000 };
		numbers = new MyArray<Integer>(1);
		for (int i = 0; i < arNumbers2.length; i++) {
			numbers.add(arNumbers2[i]);
		}
		Integer[] exp1 = { 7, 11, -2, 13, 2000 };
		assertTrue(numbers.removeAll(10));
		for (int i = 0; i < numbers.size(); i++) {
			assertEquals(exp1[i], numbers.get(i));
		}
	}

	@Test
	public void testRemoveIf() {
		Integer[] arExp1 = { 11, 13, 2000 };
		Predicate<Integer> pred = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t < 11;
			}
		};
		assertTrue(numbers.removeIf(pred));
		assertArrayEquals(arExp1, numbers.toArray());

		assertFalse(numbers.removeIf(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t > 10000;
			}
		}));
		assertArrayEquals(arExp1, numbers.toArray());
	}
}
