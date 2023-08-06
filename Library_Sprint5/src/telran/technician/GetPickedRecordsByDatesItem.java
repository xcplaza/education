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
		LocalDate from = inOut.inputDate("Enter from date in format yyyy-MM-dd", "yyyy-MM-dd");
		if (from == null)
			return;
		LocalDate nowDate = LocalDate.now();
//	    String del = inOut.inputString("If you want enter date now? " 
//		        + isbn +". Enter <<yes>>");
//		      if (del.equalsIgnoreCase("yes"));
		
		LocalDate to = inOut.inputDate("Enter " + nowDate + " or in format yyyy-MM-dd", "yyyy-MM-dd");
		if (to == null)
			return;
		inOut.output(library.getPickedRecordsAtDates(from, to));
	}

}
