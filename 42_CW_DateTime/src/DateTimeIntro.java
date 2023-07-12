import java.time.*;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateTimeIntro {

	public static void main(String[] args) {
//		Local Date
		LocalDate date = LocalDate.now();
		System.out.println(date);
		LocalDate date1 = LocalDate.of(2000, 10, 10);
		System.out.println(date1);
		LocalDate date2 = LocalDate.of(2000, Month.FEBRUARY, 15);
		System.out.println(date2);
		LocalDate date3 = LocalDate.parse("1999-12-29");
		System.out.println(date3);
		LocalDate date4 = LocalDate.ofYearDay(2020, 300);
		System.out.println(date4);
		System.out.println();

		System.out.println(date1.getDayOfYear());
		System.out.println(date1.getDayOfWeek());
		System.out.println(date1.getDayOfWeek().getValue());
		System.out.println(date1.getDayOfMonth());
		System.out.println();

		System.out.println(LocalDate.now().getDayOfWeek());
		date4 = LocalDate.now().withYear(1980);
		System.out.println(date4);
		System.out.println(date4.getDayOfWeek());
		System.out.println();

		System.out.println(date2.plusYears(21));
		System.out.println(date2.plusWeeks(10));
		System.out.println(date2.plusMonths(-5));
		System.out.println(date2.minusMonths(5));
		System.out.println(date2.minusYears(2019));
		System.out.println(date2.plusYears(10).plusMonths(1).plusWeeks(1).plusDays(4));
		System.out.println(date.plus(Period.ofWeeks(50)));
		System.out.println(date.plus(50, ChronoUnit.WEEKS));
		System.out.println();

		System.out.println(ChronoUnit.DAYS.between(date3, date4));
		LocalDate birthDatePushkin = LocalDate.parse("1799-06-06");
		LocalDate barMizvaPushkin = birthDatePushkin.plusYears(13);
		System.out.println("Pushkin's birthDate: " + birthDatePushkin);
		System.out.println("Pushkin's bar mizva date: " + barMizvaPushkin);
		ChronoUnit unit = ChronoUnit.DAYS;
		System.out.printf("period between bar mizva and birthdate: %d %s\n",
				unit.between(birthDatePushkin, barMizvaPushkin), unit);
		System.out.println();

		System.out.println(date.isAfter(date2));
		System.out.println(date.isBefore(date2));
		System.out.println(date.getEra());
		System.out.println(date.minusYears(2030).getEra());
//		ChronoUnit unit2 = ChronoUnit.SECONDS;
//		System.out.printf("period between bar mizva and birthdate: %d %s\n",
//				unit2.between(birthDatePushkin, barMizvaPushkin), unit2);

		LocalTime time = LocalTime.now();
		System.out.println(time);
		time = LocalTime.of(12, 10);
		System.out.println(time);
		time = LocalTime.of(18, 15, 10);
		System.out.println(time);
		time = LocalTime.of(23, 59, 59, 7000);
		System.out.println(time);
		time = LocalTime.ofSecondOfDay(9_124);
		System.out.println(time);
		time = LocalTime.ofNanoOfDay(100_000_000_000L);
		System.out.println(time);
		time = LocalTime.parse("10:01:23");
		System.out.println(time);
		LocalTime plusMillis = time.plus(Duration.ofMillis(100));
		System.out.println(plusMillis);
		LocalTime plusHalfSay = time.plus(1, ChronoUnit.HALF_DAYS);
		System.out.println(plusHalfSay);
		System.out.println();

//		============= LocalDateTime ===================
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		System.out.println();

		LocalDateTime birthDateAS = LocalDateTime.parse("1799-06-06T00:00");
		LocalDateTime barMizvaAS = birthDateAS.plusYears(13);
		ChronoUnit unit2 = ChronoUnit.SECONDS;
		System.out.printf("period between bar mizva and birthdate: %d %s\n", unit2.between(birthDateAS, barMizvaAS),
				unit2);
		LocalDateTime ldt1 = LocalDateTime.of(2002, Month.OCTOBER, 13, 00, 00, 1, 1);
		System.out.println(ldt1);
		LocalDateTime ldt2 = LocalDateTime.of(date, time);
		System.out.println(ldt2);
		System.out.println();

//		================= Formatter ===================
		LocalDateTime tst = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, dd/MMM/yyyy hh:mm:ss a");
//		yy(short) yyyy(full) - year
//		MM(short name) MMM(short name) MMMM(full name) - month
//		dd - day
//		E(full name) ee(int) eeee(full name) - week day
//		HH(24) hh(12) a(am/pm) - hours
//		mm - minute
//		ss - second
		System.out.println(tst.format(dtf));
		dtf = DateTimeFormatter.ofPattern("dd/MMMM/yyyy eeee", Locale.ENGLISH);
		System.out.println(tst.format(dtf));
		dtf = DateTimeFormatter.ofPattern("dd/MMMM/yyyy eeee", Locale.forLanguageTag("he"));
		System.out.println(tst.format(dtf));
		System.out.println();

		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("E, dd/MMM/yyyy hh:mm:ss a", Locale.ENGLISH);
		LocalDateTime res = LocalDateTime.parse("Mon, 01/May/2023 08:14:30 PM", dtf2);
		System.out.println(res);

		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
		ZonedDateTime zdt1 = ZonedDateTime.now(ZoneId.of("Asia/Almaty"));
		System.out.println(zdt1);
		ZonedDateTime zdt2 = ZonedDateTime.now(ZoneId.of("GMT-4"));
//		System.out.println(zdt2);
//		for (String str : ZoneId.getAvailableZoneIds()) {
//			System.out.println(str);
//		}
		System.out.println();

//		ZonedDateTime almatyTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Almaty"));
//		System.out.println(almatyTime);

		JapaneseDate jd = JapaneseDate.now();
		System.out.println(jd);

	}

}
