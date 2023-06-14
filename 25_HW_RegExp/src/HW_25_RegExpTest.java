import static org.junit.Assert.*;

import org.junit.Test;

public class HW_25_RegExpTest {

	@Test
	public void programmingNameTest() {
		// allowed letters - Any English letter
		// allowed digits - any digit
		// allowed symbols _
		// first symbol can't be a digit

		// right names
		assertTrue(StringExpressions.isProgrammingName("__"));
		assertTrue(StringExpressions.isProgrammingName("abc1"));
		assertTrue(StringExpressions.isProgrammingName("lmnpr"));
		assertTrue(StringExpressions.isProgrammingName("Lmnpr"));
		assertTrue(StringExpressions.isProgrammingName("ab_1"));
		assertTrue(StringExpressions.isProgrammingName("cd23456"));
		assertTrue(StringExpressions.isProgrammingName("_"));
		// wrong names
		assertFalse(StringExpressions.isProgrammingName("ab c"));
		assertFalse(StringExpressions.isProgrammingName("fr#3"));
		assertFalse(StringExpressions.isProgrammingName("ab+c"));
		assertFalse(StringExpressions.isProgrammingName("lmt&"));
	}

	@Test
	public void matcherThreeDigitsNumber() {
		assertEquals(true, StringExpressions.isThreeDigitsNumber("123"));
		assertEquals(true, StringExpressions.isThreeDigitsNumber("905"));
		assertEquals(false, StringExpressions.isThreeDigitsNumber("1o3"));
		assertEquals(false, StringExpressions.isThreeDigitsNumber("13"));
		assertEquals(false, StringExpressions.isThreeDigitsNumber("1234"));
		assertEquals(false, StringExpressions.isThreeDigitsNumber("000"));
		assertEquals(false, StringExpressions.isThreeDigitsNumber("001"));
	}

	@Test
	public void isWord() {
		assertTrue(StringExpressions.isWord("Word"));
		assertTrue(StringExpressions.isWord("A"));
		assertTrue(StringExpressions.isWord("word"));
		assertTrue(StringExpressions.isWord("non-word"));
		assertFalse(StringExpressions.isWord("non-wo-rd"));
		assertFalse(StringExpressions.isWord("non--word"));
		assertFalse(StringExpressions.isWord("WoRd"));
		assertFalse(StringExpressions.isWord("-Word"));
		assertFalse(StringExpressions.isWord("Word-"));
	}

	@Test
	public void matcherIsPositiveLessThan1000() {
		assertTrue(StringExpressions.isPositiveLessThan1000("1"));
		assertTrue(StringExpressions.isPositiveLessThan1000("999"));
		assertFalse(StringExpressions.isPositiveLessThan1000("1000"));
		assertFalse(StringExpressions.isPositiveLessThan1000("-1"));
		assertTrue(StringExpressions.isPositiveLessThan1000("0"));
		assertFalse(StringExpressions.isPositiveLessThan1000("000"));
	}

	@Test
	public void matcherIsPositiveLessThan300() {
		assertTrue(StringExpressions.isPositiveLessThan300("299"));
		assertTrue(StringExpressions.isPositiveLessThan300("0"));
		assertTrue(StringExpressions.isPositiveLessThan300("9"));
		assertTrue(StringExpressions.isPositiveLessThan300("50"));
		assertFalse(StringExpressions.isPositiveLessThan300("000"));
		assertFalse(StringExpressions.isPositiveLessThan300("00"));
		assertFalse(StringExpressions.isPositiveLessThan300("900"));
		assertFalse(StringExpressions.isPositiveLessThan300("300"));
	}

	@Test
	public void matcherIsPositiveLessThanEquals255() {
		assertTrue(StringExpressions.isPositiveLessThanEquals255("255"));
		assertTrue(StringExpressions.isPositiveLessThanEquals255("1"));
		assertFalse(StringExpressions.isPositiveLessThanEquals255("256"));
		assertFalse(StringExpressions.isPositiveLessThanEquals255("0"));
		assertFalse(StringExpressions.isPositiveLessThanEquals255("900"));
	}

	@Test
	public void IsraelMobileTest() {
		// right phone numbers
		assertTrue(StringExpressions.isIsraelMobile("054-1234567"));
		assertTrue(StringExpressions.isIsraelMobile("0541234567"));
		assertTrue(StringExpressions.isIsraelMobile("+97254-123-4567"));
		assertTrue(StringExpressions.isIsraelMobile("+972541234567"));
		assertTrue(StringExpressions.isIsraelMobile("+972-54-1-2-3-4-5-6-7"));
		assertTrue(StringExpressions.isIsraelMobile("058-12-34-567"));
		assertTrue(StringExpressions.isIsraelMobile("0531234-567"));
		// wrong phone numbers
		assertFalse(StringExpressions.isIsraelMobile("54-1234567"));
		assertFalse(StringExpressions.isIsraelMobile("054--12-4567"));
		assertFalse(StringExpressions.isIsraelMobile("+972054-123-4567"));
		assertFalse(StringExpressions.isIsraelMobile("97254-123-4567"));
		assertFalse(StringExpressions.isIsraelMobile("0052-1234567"));

	}
}
