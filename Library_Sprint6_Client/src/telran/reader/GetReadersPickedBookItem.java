package telran.reader;

import telran.library.cli.LibraryItem;
import telran.books.model.ILibrary;
import telran.view.InputOutput;

public class GetReadersPickedBookItem extends LibraryItem {

	public GetReadersPickedBookItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);
	}

	@Override
	public String displayName() {
		// TODO Auto-generated method stub
		return "Get Readers by Picked Book";
	}

	@Override
	public void perform() {
		Long isbn = inOut.inputLong("Enter Book Isbn");
		if (isbn == null)
			return;
		inOut.output(library.getReadersPickedBook(isbn));

	}

}
