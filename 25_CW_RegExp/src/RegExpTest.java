import static org.junit.Assert.*;

import org.junit.Test;

public class RegExpTest {

	@Test
	public void matcherTest() {
		assertTrue(RegExpIntr.isTrue("true"));
		assertTrue(RegExpIntr.isTrue("True"));
		assertFalse(RegExpIntr.isTrue("TRue"));
		assertFalse(RegExpIntr.isTrue("truetrue"));
		assertFalse(RegExpIntr.isTrue("trrue"));
		assertFalse(RegExpIntr.isTrue("Ttrrue"));
	}

	@Test
	public void matcherNumberTest() {
		assertTrue(RegExpIntr.isNumber("12345"));
		assertTrue(RegExpIntr.isNumber("9"));
		assertTrue(RegExpIntr.isNumber("-9"));
		assertTrue(RegExpIntr.isNumber("0"));
		assertFalse(RegExpIntr.isNumber("2.1"));
		assertFalse(RegExpIntr.isNumber("0021"));
		assertFalse(RegExpIntr.isNumber("021"));
		assertFalse(RegExpIntr.isNumber("4s5"));
		assertFalse(RegExpIntr.isNumber("423t"));
	}

}
