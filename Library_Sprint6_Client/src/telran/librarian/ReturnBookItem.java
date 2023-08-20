package telran.librarian;

import java.time.LocalDate;

import telran.library.cli.LibraryItem;
import telran.books.model.ILibrary;
import telran.view.InputOutput;

public class ReturnBookItem extends LibraryItem {

	public ReturnBookItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);
	}

	@Override
	public String displayName() {
		return "Return book";
	}

	@Override
	public void perform() {
		Long isbn = inOut.inputLong("Enter isbn book");
		if (isbn == null)
			return;
		Integer readerId = inOut.inputInteger("Enter reader ID");
		if (readerId == null)
			return;
		LocalDate returnDate = inOut.inputDate("Enter return date in format yyyy-MM-dd", "yyyy-MM-dd");
		if (returnDate == null)
			return;
		inOut.outputLine(library.returnBook(isbn, readerId, returnDate));
	}

}
