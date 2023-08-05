package telran.library.librarian;

import java.time.LocalDate;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class PickBookItem extends LibraryItem {

	public PickBookItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);
	}

	@Override
	public String displayName() {
		return "Pick book";
	}

	@Override
	public void perform() {
		Long isbn = inOut.inputLong("Enter isbn book");
		if (isbn == null || isbn < 0)
			return;
		Integer readerId = inOut.inputInteger("Enter readerId");
		if (readerId == null || readerId < 0)
			return;
		inOut.outputLine(library.pickBook(isbn, readerId, LocalDate.now()));
	}

}
