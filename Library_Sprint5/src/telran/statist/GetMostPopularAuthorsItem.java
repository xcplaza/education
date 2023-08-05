package telran.statist;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetMostPopularAuthorsItem extends LibraryItem {

	public GetMostPopularAuthorsItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String displayName() {
		// TODO Auto-generated method stub
		return "Get Most Popular Authors";
	}

	@Override
	public void perform() {
		inOut.outputLine(library.getMostPopularAuthors());
	}

}
