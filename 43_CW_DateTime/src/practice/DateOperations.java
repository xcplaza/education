package practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;

import javax.print.attribute.standard.Chromaticity;

public class DateOperations {

	static DateTimeFormatter formatter(String date) {
		return date.contains("-") ? DateTimeFormatter.ISO_DATE : DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}

	public static String[] sortStringDates(String[] dates) {
		Arrays.sort(dates, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				DateTimeFormatter dtf1 = formatter(o1);
				LocalDate d1 = LocalDate.parse(o1, dtf1);

				DateTimeFormatter dtf2 = formatter(o2);
				LocalDate d2 = LocalDate.parse(o2, dtf2);

				return d1.compareTo(d2);
			}
		});
		return dates;
	}

	public static Integer getAge(String birthDate, String currentDate) {
		DateTimeFormatter fbd = formatter(birthDate);
		LocalDate bd = LocalDate.parse(birthDate, fbd);

		LocalDate current;
		if (currentDate == null)
			current = LocalDate.now();
		else {
			fbd = formatter(currentDate);
			current = LocalDate.parse(currentDate, fbd);
		}
		return (int) ChronoUnit.YEARS.between(bd, current);
	}

	public static void printCurrentTimeForZone(String str) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		Set<String> zones = ZoneId.getAvailableZoneIds();
		for (String zone : zones) {
			if (zone.contains(str)) {
				ZonedDateTime time = ZonedDateTime.now(ZoneId.of(zone));
				System.out.println("<" + zone + "> - " + time.format(dtf));
			}
		}
	}
}
