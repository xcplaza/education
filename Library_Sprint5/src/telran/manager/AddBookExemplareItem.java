package telran.manager;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class AddBookExemplareItem extends LibraryItem {

	public AddBookExemplareItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);

	}

	@Override
	public String displayName() {
		return "Add book exemplare";
	}

	@Override
	public void perform() {

		Long isbn = inOut.inputLong("Enter book isbn");
		if (isbn == null)
			return;
		Integer amount = inOut.inputInteger("Enter amount");
		if (amount == null || amount <= 0)
			return;
		inOut.output(library.addBookExemplars(isbn, amount));

	}

}
