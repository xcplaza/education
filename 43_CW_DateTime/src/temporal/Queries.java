package temporal;

import java.time.*;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;

public class Queries {

	public static void main(String[] args) {
		TemporalQuery<TemporalUnit> query = TemporalQueries.precision();
		System.out.println("Local date: " + LocalDate.now().query(query));
		System.out.println("Local time: " + LocalTime.now().query(query));
		System.out.println("Local year: " + Year.now().query(query));
		System.out.println("Instant: " + Instant.now().query(query));
		System.out.println();

		System.out.println(LocalDate.now().query(new IsWeekendInIsrael()));
		System.out.println(LocalDate.now().plusDays(1).query(new IsWeekendInIsrael()));

	}

}
