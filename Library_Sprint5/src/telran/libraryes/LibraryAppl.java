package telran.libraryes;

import telran.library.cli.SaveAndExit;
import telran.library.librarian.AddReaderItem;
import telran.library.librarian.GetAuthorBookItem;
import telran.library.librarian.GetReadersDelayedBooksItem;
import telran.library.librarian.GetReadersDelayingBooksItem;
import telran.library.librarian.PickBookItem;
import telran.library.librarian.ReturnBookItem;
import telran.library.model.ILibrary;
import telran.library.model.LibraryMaps;
import telran.manager.AddBookExemplareItem;
import telran.manager.AddBookItemItem;
import telran.manager.RemoveAuthorItem;
import telran.manager.RemoveBookItem;
import telran.reader.GetBookItem;
import telran.reader.GetBooksPickedByReaderItem;
import telran.reader.GetReaderItem;
import telran.reader.GetReadersPickedBookItem;
import telran.statist.GetMostActiveReadersItem;
import telran.statist.GetMostPopularAuthorsItem;
import telran.statist.GetMostPopularBooksItem;
import telran.technician.GetPickedRecordsByDatesItem;
import telran.view.ConsoleInputOutput;
import telran.view.ExitItem;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;
import telran.view.SubMenu;

public class LibraryAppl {
	private static final String LIBRARY_FILE = "test.book";
	static ILibrary library;
	static InputOutput inOut;

	public static void main(String[] args) {
		inOut = new ConsoleInputOutput();
		library = LibraryMaps.restoreFromFile(LIBRARY_FILE);
		Menu menu = new Menu(getMainMenuItems(), inOut);
		menu.runMenu();
	}

	private static Item[] getMainMenuItems() {
		Item[] res = {
				new SubMenu("Librarian", inOut, getLibrarianMenuItems()),
				new SubMenu("Technicain", inOut, getTechnicainMenuItems()),
				new SubMenu("Manager", inOut, getManagerMenuItems()),
				new SubMenu("Statist", inOut, getStatistMenuItems()),
				new SubMenu("Reader", inOut, getReaderMenuItems()),
				new SaveAndExit(inOut, library, LIBRARY_FILE)
		};
		return res;
	}

	private static Item[] getReaderMenuItems() {
		Item[] res = {
				new GetBookItem(inOut, library),
				new GetBooksPickedByReaderItem(inOut, library),
				new GetReaderItem(inOut, library),
				new GetReadersPickedBookItem(inOut, library),
				new ExitItem()
		};
		return res;
	}

	private static Item[] getStatistMenuItems() {
		Item[] res = {
				new GetMostActiveReadersItem(inOut, library),
				new GetMostPopularAuthorsItem(inOut, library),
				new GetMostPopularBooksItem(inOut, library),
				new ExitItem()
		};
		return res;
	}

	private static Item[] getManagerMenuItems() {
		Item[] res = {
				new AddBookExemplareItem(inOut, library),
				new AddBookItemItem(inOut, library),
				new RemoveAuthorItem(inOut, library),
				new RemoveBookItem(inOut, library),
				new ExitItem()
		};
		return res;
	}

	private static Item[] getTechnicainMenuItems() {
		Item[] res = {
				new GetPickedRecordsByDatesItem(inOut, library),
				new ExitItem()
		};
		return res;
	}

	private static Item[] getLibrarianMenuItems() {
		Item[] res = {
				new AddReaderItem(inOut, library),
				new GetAuthorBookItem(inOut, library),
				new GetReadersDelayedBooksItem(inOut, library),
				new GetReadersDelayingBooksItem(inOut, library),
				new PickBookItem(inOut, library),
				new ReturnBookItem(inOut, library),
				new ExitItem()
		};
		return res;
	}

}
