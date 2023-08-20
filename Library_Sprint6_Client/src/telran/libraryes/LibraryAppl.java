package telran.libraryes;

import telran.books.model.ILibrary;
import telran.librarian.AddReaderItem;
import telran.librarian.GetAuthorBookItem;
import telran.librarian.GetReadersDelayedBooksItem;
import telran.librarian.GetReadersDelayingBooksItem;
import telran.librarian.PickBookItem;
import telran.librarian.ReturnBookItem;
import telran.library.*;
import telran.library.model.LibraryProxy;
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
	static ILibrary library;
	static InputOutput inOut = new ConsoleInputOutput();
	static String hostname = "localhost";
	static int port = 2000;
	
	public static void main(String[] args) throws Exception {
		inOut = new ConsoleInputOutput();
		library = new LibraryProxy(hostname, port);
		Menu menu = new Menu(getMainMenuItems(), inOut);
		menu.runMenu();
	}

	private static Item[] getMainMenuItems() {
		Item[] res = { new SubMenu("Librarian", inOut, getLibrarianMenuItems()),
				new SubMenu("Technicain", inOut, getTechnicainMenuItems()),
				new SubMenu("Manager", inOut, getManagerMenuItems()),
				new SubMenu("Statist", inOut, getStatistMenuItems()),
				new SubMenu("Reader", inOut, getReaderMenuItems()), };
		return res;
	}

	private static Item[] getReaderMenuItems() {
		Item[] res = { 
				new GetBookItem(inOut, library),
				new GetBooksPickedByReaderItem(inOut, library),
				new GetReaderItem(inOut, library), 
				new GetReadersPickedBookItem(inOut, library), 
				new ExitItem() };
		return res;
	}

	private static Item[] getStatistMenuItems() {
		Item[] res = { 
				new GetMostActiveReadersItem(inOut, library), 
				new GetMostPopularAuthorsItem(inOut, library),
				new GetMostPopularBooksItem(inOut, library), 
				new ExitItem() };
		return res;
	}

	private static Item[] getManagerMenuItems() {
		Item[] res = { 
				new AddBookExemplareItem(inOut, library), 
				new AddBookItemItem(inOut, library),
				new RemoveAuthorItem(inOut, library), 
				new RemoveBookItem(inOut, library), 
				new ExitItem() };
		return res;
	}

	private static Item[] getTechnicainMenuItems() {
		Item[] res = { 
				new GetPickedRecordsByDatesItem(inOut, library), 
				new ExitItem() };
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
				new ExitItem() };
		return res;
	}

}
