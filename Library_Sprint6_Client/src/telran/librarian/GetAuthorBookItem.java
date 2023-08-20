package telran.librarian;

import telran.library.cli.LibraryItem;
import telran.books.model.ILibrary;
import telran.view.InputOutput;

public class GetAuthorBookItem extends LibraryItem {

	public GetAuthorBookItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);
	}

	@Override
	public String displayName() {
		return "Get author books";
	}

	@Override
	public void perform() {
		String author = inOut.inputString("Enter author");
		if (author == null || author.isEmpty())
			return;
		inOut.outputLine(library.getBooksAuthor(author));
	}

}
