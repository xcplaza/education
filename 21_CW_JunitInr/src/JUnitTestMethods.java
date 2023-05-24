import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTestMethods {

	@Test
	public void test() {
		assertEquals(4, 2 + 2);
		assertEquals(4, Methods.sum(2, 2));
	}

	@Test
	public void testDouble() {
		assertEquals(3.14, 2. + 1.14, 0.00001); // нужна погрешность! (3й апперанд)
	}

	@Test
	public void testObject() {
		assertEquals("Hello", "Hello");
		assertNull(null);
		assertNotNull("");
	}

	@Test
	public void testNotEquals() {
		assertNotEquals("Hello", "Kello");
		assertTrue(2 == 2);
		assertTrue("Hello".equalsIgnoreCase("hello"));
		assertFalse(2 != 2);
		assertFalse("Hello".equals("hello"));
	}

//	@Test(expected = ) - если мы ожидаем ошибку и знаем про нее
	@Test
	public void testArrays() {
		int[] ar1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] ar2 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		assertArrayEquals(ar1, ar2);
		int[] ar3 = { 1, 2, 3, 4, 5, 6, 7 };
//		assertArrayEquals(ar1, ar3);
		int[] ar4 = { 1, 2, 3, 4, 5, 6, 9 };
		assertArrayEquals(ar3, ar4);
	}

	@Test(timeout = 500)
	public void testTImeUot() {
		while(true);
	}
}
