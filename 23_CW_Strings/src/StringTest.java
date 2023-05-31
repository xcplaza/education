import static org.junit.Assert.*;

import org.junit.Test;

public class StringTest {

	@Test
	public void testStringMethods() {
		String str = "Zelenoglazka";
		assertEquals(12, str.length());
		assertEquals('l', str.charAt(2));
		assertEquals(2, str.indexOf('l')); // поиск символа (первоговстреченного) и сравнение со значением
		assertEquals(-1, str.indexOf('w'));
		assertEquals(7, str.lastIndexOf('l')); // поиск символа (последнего встреченного) и сравнение со значением
		assertTrue(str.indexOf('l') != str.lastIndexOf('l')); // проверяем что бук l более чем одна
		assertEquals("Zelenoglazka!", str.concat("!")); // проверяем zelenoglazka! и приклеиваем к старой zele + !
		assertEquals("Zelenoglazka", str); // проверяем что мы не изменили строку
		assertTrue(str.equals("Zelenoglazka"));
		assertFalse(str.equals("zelenoglazka"));
		assertTrue(str.equalsIgnoreCase("ZELENOGLAZKA"));
		String test1 = "ZELENOGLAZKA";
		assertTrue(test1.equals(str.toUpperCase()));
		Character.toUpperCase(0); // заглавная певая буква
		String test2 = "zelenoglazka";
		assertTrue(test2.equals(str.toLowerCase()));
		String test3 = " \tHello     ";
		assertEquals("Hello", test3.trim()); // проверяем отсутсвие пробелов только перед и после слова
		test3 = " \tHe llo     ";
		assertEquals("He llo", test3.trim()); // проверяем отсутсвие пробелов только перед и после слова
		char[] chars = "Bye".toCharArray();
		assertArrayEquals(new char[] { 'B', 'y', 'e' }, chars);
	}

	@Test
	public void testIsNumber() {
		String str = "12.54";
		assertTrue(StringsIntr.isNumber(str)); // проверяем что в массиве цифры черед метод isNumber
		str = "123";
		assertTrue(StringsIntr.isNumber(str));
		str = "12.5.4";
		assertFalse(StringsIntr.isNumber(str)); // проверяем что более 2х точек будет ошибка
		str = null;
		assertFalse(StringsIntr.isNumber(str));
		str = " ";
		assertFalse(StringsIntr.isNumber(str));
	}

	@Test
	public void testisPalindrom() {
		String str = "kazak";
		assertTrue(StringsIntr.isPalindrom(str));
		str = "  kazak\t";
		assertTrue(StringsIntr.isPalindrom(str));
		str = "Kazak";
		assertTrue(StringsIntr.isPalindrom(str));
		str = "Kaza K";
		assertFalse(StringsIntr.isPalindrom(str));
		str = "   ";
		assertFalse(StringsIntr.isPalindrom(str));
		str = "";
		assertFalse(StringsIntr.isPalindrom(str));
		str = null;
		assertFalse(StringsIntr.isPalindrom(str));
	}

}
