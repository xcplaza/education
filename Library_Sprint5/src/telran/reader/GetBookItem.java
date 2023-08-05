package telran.reader;

import telran.library.cli.LibraryItem;
import telran.library.entities.Book;
import telran.library.entities.BooksReturnCode;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetBookItem extends LibraryItem {

	public GetBookItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);
	}

	@Override
	public String displayName() {
		return "Get a book";
	}

	@Override
	public void perform() {
	    Long isbn = inOut.inputLong("Enter book ISBN or cancel");
	    if(isbn == null) 
	      return;
	    Book book = library.getBookItem(isbn);
	    inOut.outputLine(book==null? BooksReturnCode.NO_BOOK_ITEM: book);
	  }
}
