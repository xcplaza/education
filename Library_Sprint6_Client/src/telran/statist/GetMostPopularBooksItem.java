package telran.statist;

import java.time.LocalDate;

import telran.library.cli.LibraryItem;
import telran.books.model.ILibrary;
import telran.view.InputOutput;

public class GetMostPopularBooksItem extends LibraryItem {

	public GetMostPopularBooksItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String displayName() {
		// TODO Auto-generated method stub
		return "Get most popular books";
	}

	@Override
	public void perform() {
		// .LocalDate fromDate, LocalDate toDate, int fromAge, int toAge
		LocalDate fromDate = inOut.inputDate("Enter from Date", "yyyy-MM-dd");
		LocalDate toDate = inOut.inputDate("Enter to Date", "yyyy-MM-dd");
		Integer fromAge = inOut.inputInteger("Enter from age");
		Integer toAge = inOut.inputInteger("Enter to age ");
		inOut.outputLine(library.getMostPopularBooks(fromDate, toDate, fromAge, toAge));

	}

}
