import static org.junit.Assert.*;

import org.junit.Test;

public class LenghtTest {

	Lenght l1 = new Lenght(10, LenghtUnit.M);
	Lenght l2 = new Lenght(1000, LenghtUnit.CM);
	Lenght l3 = new Lenght(20, LenghtUnit.M);

	@Test
	public void testToString() {
		assertEquals("10.0M", l1.toString());
		assertEquals("1000.0CM", l2.toString());
	}

	@Test
	public void testPlus() {
		Lenght res = new Lenght(20, LenghtUnit.M);
		assertEquals(res, l1.plus(l2));

		res = new Lenght(2000, LenghtUnit.CM);
		assertEquals(res, l2.plus(l1));
	}

	@Test
	public void testConvert() {
		assertEquals(l2, l1.convert(LenghtUnit.CM));
		assertEquals(l1, l2.convert(LenghtUnit.M));
	}

	@Test
	public void testMinus() {
		Lenght res = new Lenght(0, LenghtUnit.M);
		assertEquals(res, l1.minus(l2));

		res = new Lenght(0, LenghtUnit.CM);
		assertEquals(res, l2.minus(l1));
	}

	@Test
	public void testBetween() {
		assertEquals(-10000., LenghtUnit.MM.between(l3, l2), 0.0001);
		assertEquals(10., LenghtUnit.M.between(l2, l3), 0.0001);
		assertEquals(-1000., LenghtUnit.CM.between(l3, l2), 0.0001);
	}

}
