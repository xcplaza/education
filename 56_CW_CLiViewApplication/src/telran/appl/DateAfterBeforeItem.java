package telran.appl;

import java.time.LocalDate;
import telran.view.InputOutput;
import telran.view.Item;

public class DateAfterBeforeItem implements Item {
	String format = "yyyy-MM-dd";
	InputOutput inOut;
	LocalDate date;
	long days;
	String either;

	public DateAfterBeforeItem(InputOutput inOut) {
		super();
		this.inOut = inOut;
	}

	@Override
	public String displayName() {
		return "Date after or before given amount days";
	}

	@Override
	public void perform() {
		LocalDate date = inOut.inputDate("Enter date " + format, "yyyy-MM-dd");
		if (date == null)
			return;
		Long days = inOut.inputLong("Enter days ");
		if (days == null)
			return;
		String operator = inOut.inputString(either);
		if (either == "+")
			date.plusDays(days);
		if (either == "-")
			date.minusDays(days);
		inOut.outputLine(date);
	}

}
