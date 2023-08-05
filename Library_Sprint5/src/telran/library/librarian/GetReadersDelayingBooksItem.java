package telran.library.librarian;

import java.time.LocalDate;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetReadersDelayingBooksItem extends LibraryItem {

	public GetReadersDelayingBooksItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);
	}

	@Override
	public String displayName() {
		return "Get readers delaing books";
	}

	@Override
	public void perform() {
		LocalDate currentDate = inOut.inputDate("Enter date in formate yyyy-MM-dd ", "yyyy-MM-dd");
		if (currentDate == null)
			return;
		inOut.outputLine(library.getReadersDelayingBooks(currentDate));
	}

}
