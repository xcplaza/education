package practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DateOperationsTest {
	String[] dates = { "2000-12-01", "20/12/2000", "1970-08-22", "2010-10-05" };
	String[] expected = { "1970-08-22", "2000-12-01", "20/12/2000", "2010-10-05" };

	@Test
	void testSortDates() {
		String[] actual = DateOperations.sortStringDates(dates);
		assertArrayEquals(actual, expected);
	}

	@Test
	void testAge() {
		String birthDate = "12/04/1960";
		String currentDate = "2020-11-11";
		assertEquals(60, DateOperations.getAge(birthDate, currentDate));
		assertEquals(63, DateOperations.getAge(birthDate, null));
	}

	@Test
	void testPrintCurrentTimeForZone() {
		DateOperations.printCurrentTimeForZone("America");
//		<zone name> - HH:mm
	}

}
