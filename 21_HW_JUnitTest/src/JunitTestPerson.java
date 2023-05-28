import static org.junit.Assert.*;

import org.junit.Test;

public class JunitTestPerson {
	Person p1 = new Person(123, "Vasya");

	@Test
	public void testEqulas() {
		Person p2 = new Person(123, "Vasya");
		assertTrue(p1.equals(p2));
		Person p4 = new Person(1230, "Vasya");
		assertFalse(p1.equals(p4));
		Person p5 = new Person(123, "vasya");
		assertFalse(p1.equals(p5));
	}

	@Test
	public void testConstructorPerson() {
		Person p3 = new Person();
		assertEquals(0, p3.getId());
//		assertEquals("No name!", p3.getName());
		assertNull(p3.getName());
		assertFalse(p1.equals(p3));
		p3.setId(123);
		p3.setName("Vasya");
		assertTrue(p1.equals(p3));
		assertEquals(p1, p3);
	}

	@Test
	public void testSetters() {
		Person test = new Person(123, "Vasya");
		assertEquals(p1, test);
		test.setId(100);
		test.setName("Petya");
		assertEquals(p1, test);
		assertEquals(100, test.getId());
		assertEquals("Petya", test.getName());
//		======================================
		test.setId(-1);
		test.setName(null);
		assertEquals(100, test.getId());
		assertEquals("Petya", test.getName());
		test.setName("");
		assertEquals("Petya", test.getName());
		test.setName("  \t \n");
		assertEquals("Petya", test.getName());

	}
}
