package calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;

public class PrintCalendarAppl {

//	private static final int DATE_W = 4;

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
//		YearMonth ym = YearMonth.of(year, month);
//		int days = ym.lengthOfMonth();
//
//		System.out.println("  ");
//		for (int i = 0; i < days; i++) {
//			System.out.printf("%" + DATE_W + "d", i);
//			if (firstColumn == 7) {
//				firstColumn = 1;
//				System.out.println();
//			} else {
//				firstColumn++;
//			}
//		}

		int daysInMonth = getDaysInMonth(month, year);
		int currentDay = 1;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (i == 0 && j < firstColumn) {
					System.out.print(" "); // Выводим пробелы до начала месяца
				} else if (currentDay <= daysInMonth) {
					System.out.printf("%4d", currentDay); // Выводим числа месяца
					currentDay++;
				} else {
					System.out.print("   "); // Выводим пробелы после окончания месяца
				}
			}
			System.out.println();
		}

	}

	private static int getDaysInMonth(int month, int year) {
		boolean isLeapYear = Year.of(year).isLeap();
		return Month.of(month).length(isLeapYear);
	}

	private static void printOffSet(int firstColumn) {
		for (int i = 0; i < firstColumn; i++) {
			System.out.print("   "); // Выводим пробелы для смещения
		}
	}

	private static int getFirstColumn(int month, int year) {
		LocalDate date = LocalDate.of(year, month, 1);
//		DayOfWeek dayOfWeek = date.getDayOfWeek();
		return date.getDayOfWeek().getValue() % 7;
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
		System.out.printf("%8s %s %d\n", " ", res, year);
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
