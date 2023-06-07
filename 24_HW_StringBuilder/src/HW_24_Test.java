import static org.junit.Assert.*;

import org.junit.Test;

public class HW_24_Test {

	@Test
	public void maxChartIndexTest() {
		assertEquals(9, HW_24_StringBuilder.maxCharIndex("aaabbccccddddd"));
		assertEquals(3, HW_24_StringBuilder.maxCharIndex("aaabbbbbbccccddddd"));
		assertEquals(9, HW_24_StringBuilder.maxCharIndex("aaabbccccdddddaaaa"));
//		assertEquals(14, HW_24_StringBuilder.maxCharIndex("aaabbccccdddddaaaaaa"));
		assertEquals(-1, HW_24_StringBuilder.maxCharIndex(null));
		assertEquals(-1, HW_24_StringBuilder.maxCharIndex(""));
		assertEquals(-1, HW_24_StringBuilder.maxCharIndex("\t"));
	}

	@Test
	public void maxCharOccurances() {
		HW_24_StringBuilder.maxCharOccurances("mama myla ramu");
		HW_24_StringBuilder.maxCharOccurances("Mama myla ramu");
		HW_24_StringBuilder.maxCharOccurances("mama myla ramum");
		HW_24_StringBuilder.maxCharOccurances("m a m a m y l a r a m u");
		HW_24_StringBuilder.maxCharOccurances(null);
	}

}
