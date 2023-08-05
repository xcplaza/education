package telran.reader;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetReaderItem extends LibraryItem {

	public GetReaderItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String displayName() {
		// TODO Auto-generated method stub
		return "Get Reader";
	}

	@Override
	public void perform() {
		Integer readerId = inOut.inputInteger("Enter Reader ID or cancel");
		if (readerId == null)
			return;
		inOut.outputLine(library.getReader(readerId));
	}

}
