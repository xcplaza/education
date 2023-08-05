package telran.technician;

import java.time.LocalDate;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetPickedRecordsByDatesItem extends LibraryItem {

	public GetPickedRecordsByDatesItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);
	}

	@Override
	public String displayName() {
		return "Get picked records by dates";
	}

	@Override
	public void perform() {

		LocalDate from = inOut.inputDate("Enter the date from which you want to request records in format yyyy-MM-dd",
				"yyyy-MM-dd");
		if (from == null)
			return;

		LocalDate to = inOut.inputDate("Enter the date ин which you want to request records in format yyyy-MM-dd",
				"yyyy-MM-dd");
		if (to == null)
			return;
		inOut.output(library.getPickedRecordsAtDates(from, to));
	}

}
