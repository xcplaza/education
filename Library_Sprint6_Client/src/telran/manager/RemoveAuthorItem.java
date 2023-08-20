package telran.manager;

import java.util.List;

import telran.library.cli.LibraryItem;
import telran.books.model.ILibrary;
import telran.view.InputOutput;

public class RemoveAuthorItem extends LibraryItem {

	public RemoveAuthorItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);
	}

	@Override
	public String displayName() {
		return "Remove author";
	}

	@Override
	public void perform() {
		List<String> authors = library.getAuthors();
		String author = inOut.InputString("Enter book author" + authors, authors);
		if (author == null)
			return;
		String del = inOut.inputString("Do you want to delete author " + author + ". Enter <<yes>>");
		if (del.equalsIgnoreCase("yes"))
			inOut.output(library.removeAuthor(author));
		else
			return;
	}

}
