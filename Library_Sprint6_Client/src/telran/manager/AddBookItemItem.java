package telran.manager;

import telran.books.dto.Book;
import telran.library.cli.LibraryItem;
import telran.books.model.ILibrary;
import telran.view.InputOutput;

public class AddBookItemItem extends LibraryItem {

	public AddBookItemItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);

	}

	@Override
	public String displayName() {
		return "Add book item";
	}

	@Override
	public void perform() {

		Long isbn = inOut.inputLong("Enter book isbn");
		if (isbn == null)
			return;
		String title = inOut.inputString("Enter book title");
		if (title == null)
			return;
		String author = inOut.inputString("Enter book author");
		if (author == null)
			return;
		Integer amount = inOut.inputInteger("Enter amount");
		if (amount == null || amount <= 0)
			return;
		Integer pickPeriod = inOut.inputInteger("Enter pickPeriod");
		Book book = new Book(isbn, title, author, amount, pickPeriod);
		inOut.output(library.addBookItem(book));

	}

}
