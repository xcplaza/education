import static org.junit.Assert.*;

import org.junit.Test;

public class JunitTestPerson {

	@Test
	public void testEqulas() {
		Person p1 = new Person(123, "Vasya");
		Person p2 = new Person(123, "Vasya");
		assertTrue(p1.equals(p2));
	}

	@Test
	public void testConstructorPerson() {
		Person p1 = new Person(123, "Vasya");
		Person p3 = new Person();
		p3.setId(123);
		p3.setName("Vasya");
		assertEquals(p1, p3);
	}
}
