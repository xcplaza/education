package telran.library.cli;

import telran.library.model.ILibrary;
import telran.view.InputOutput;
import telran.view.Item;

public abstract class LibraryItem implements Item {
	protected InputOutput inOut;
	protected ILibrary library;

	public LibraryItem(InputOutput inOut, ILibrary library) {
		super();
		this.inOut = inOut;
		this.library = library;
	}

}
