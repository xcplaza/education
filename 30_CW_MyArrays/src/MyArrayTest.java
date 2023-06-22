import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyArrayTest {
	IList numbers;
	IList strings;
	Integer[] arNumbers = {10, 7, 11, -2, 13, 10, 2000};
	String[] arStrings = {"abc", "lmn", "fg", "abc"};

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

}
