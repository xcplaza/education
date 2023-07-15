package calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Iterator;
import java.util.Locale;

public class PrintCalendarAppl {

	public static void main(String[] args) {

		int[] monthYear = args.length == 2 ? getMonthYear(args) : getCurrentMonthYear();
		if (monthYear == null) {
			System.out.println("Wrong input, must be <month number> < year number>");
			return;
		}
		printMothYear(monthYear[0], monthYear[1]);
	}

	private static void printMothYear(int month, int year) {
		printTitle(month, year);
		printWeekDaysNames();
		printDates(month, year);
	}

	private static void printDates(int month, int year) {
		int firstColumn = getFirstColumn(month, year);
		printOffSet(firstColumn); // пробелы смещения
		printNumbersFromOffSet(firstColumn, month, year); // наполняем числами (* от 1 - вск до 7 - суб)

	}

	private static void printNumbersFromOffSet(int firstColumn, int month, int year) {
		// TODO Auto-generated method stub
		
	}

	private static void printOffSet(int firstColumn) {
		// TODO Auto-generated method stub
		
	}

	private static int getFirstColumn(int month, int year) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static void printWeekDaysNames() {
		for (int i = 1; i <= 7; i++) {
			DayOfWeek day = DayOfWeek.of(i);
			String res = day.getDisplayName(TextStyle.SHORT, Locale.forLanguageTag("en"));
			System.out.print(res + " ");
		}
		System.out.println();
	}

	private static void printTitle(int month, int year) {
		Month m = Month.of(month);
		String res = m.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		System.out.printf("%8s%s %d\n", " ", res, year);
	}

	private static int[] getCurrentMonthYear() {
		LocalDate res = LocalDate.now();
		return new int[] { res.getMonthValue(), res.getYear() };
	}

	private static int[] getMonthYear(String[] args) {
		int[] res = new int[2];
		try {
			res[0] = Integer.parseInt(args[0]);// month
			res[1] = Integer.parseInt(args[1]);// year
			if (res[0] < 1 || res[0] > 12)
				return null;
			return res;
		} catch (Exception e) {
			return null;
		}
	}

}
