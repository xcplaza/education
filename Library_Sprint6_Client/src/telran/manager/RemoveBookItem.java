package telran.manager;

import telran.library.cli.LibraryItem;
import telran.books.model.ILibrary;
import telran.view.InputOutput;

public class RemoveBookItem extends LibraryItem {

	public RemoveBookItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);

	}

	@Override
	public String displayName() {
		return "Remove book";
	}

	@Override
	  public void perform() {
	    Long isbn = inOut.inputLong("Enter book isbn");
	    if (isbn == null)
	      return;
	    String del = inOut.inputString("If you are sure you want to delete book " 
	        + isbn +". Enter <<yes>>");
	      if (del.equalsIgnoreCase("yes"))
	    inOut.output(library.removeBook(isbn));
	    
	  }
}
