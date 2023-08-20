package telran.librarian;

import telran.library.cli.LibraryItem;
import telran.books.model.ILibrary;
import telran.view.InputOutput;

public class GetReadersDelayedBooksItem extends LibraryItem {

	public GetReadersDelayedBooksItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);
	}

	@Override
	public String displayName() {
		return "Get readers delayed books";
	}

	@Override
	public void perform() {
		inOut.outputLine(library.getReadersDelayedBooks());
	}

}
