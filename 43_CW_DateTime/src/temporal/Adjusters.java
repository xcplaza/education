package temporal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Adjusters {

	public static void main(String[] args) {

		LocalDate date = LocalDate.now();
		System.out.println(date.with(TemporalAdjusters.firstDayOfMonth()));
		System.out.println(date.with(TemporalAdjusters.lastDayOfMonth()));
		System.out.println(date.with(TemporalAdjusters.firstDayOfYear()));
		System.out.println(date.with(TemporalAdjusters.lastDayOfYear()));
		System.out.println(date.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY)));
		System.out.println(date.plusYears(1).with(TemporalAdjusters.lastDayOfYear()));
		System.out.println();

		TemporalAdjuster lastDayOfYear = TemporalAdjusters.lastDayOfYear();
		LocalDate lastDay = LocalDate.of(1999, 1, 1).with(lastDayOfYear);
		System.out.println(lastDay);

		lastDay = date.with(lastDayOfYear);
		Period period = date.until(lastDay);
		System.out.printf("Until New Year left %d years %d months %d days\n", period.getYears(), period.getMonths(),
				period.getDays());
		System.out.println(ChronoUnit.DAYS.between(date, lastDay));
		System.out.println();

		System.out.println(date.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)));
		System.out.println(date.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)));
		System.out.println(date.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)));
		System.out.println(date.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY)));
		System.out.println();

		System.out.println(date.with(new NonLeapYear(10)));
	}

}
