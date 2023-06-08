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
	}

	@Test
	public void isWord() {
		assertTrue(StringExpressions.isWord("Word"));
		assertTrue(StringExpressions.isWord("word"));
		assertTrue(StringExpressions.isWord("non-word"));
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
	}

	@Test
	public void matcherIsPositiveLessThan300() {
		assertTrue(StringExpressions.isPositiveLessThan300("299"));
		assertTrue(StringExpressions.isPositiveLessThan300("0"));
		assertTrue(StringExpressions.isPositiveLessThan300("9"));
		assertFalse(StringExpressions.isPositiveLessThan300("300"));
	}
}
