package telran.reader;

import java.util.List;

import telran.books.dto.Book;
import telran.books.model.ILibrary;
import telran.library.cli.LibraryItem;

import telran.view.InputOutput;

public class GetBooksPickedByReaderItem extends LibraryItem {

	public GetBooksPickedByReaderItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);
	}

	@Override
	public String displayName() {

		return "Get Book by Reader";

	}

	@Override
	public void perform() {
		Integer readerId = inOut.inputInteger("Enter ID of Reader");
		if (readerId == null)
			return;
		List<Book> res = library.getBooksPickedByReader(readerId);
		if (res.isEmpty()) {
			inOut.outputLine("No books for reader");
			return;
		}
		res.forEach(inOut::outputLine);

	}

}
