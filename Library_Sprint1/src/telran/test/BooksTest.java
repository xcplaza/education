package telran.test;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import telran.library.entities.Book;
import telran.library.entities.Reader;
import telran.library.model.ILibrary;
import telran.library.model.LibraryMaps;
import telran.util.Persistable;

public class BooksTest {
	private static String FILE_NAME = "library.data";
	private static long ISBN = 987654321;
	private static String TITLE = "Harry Potter";
	private static String AUTOR = "autor1";
	private static int AMOUNT = 10;
	private static int AMOUNT_IN_USE = 5;
	private static int PICK_PERIOD = 15;
	private static int READER_ID = 123;
	private static String NAME = "reader1";
	private static String PHONE = "0534381124";
	private static LocalDate BIRTH_DATE = LocalDate.of(1983, 02, 11);
	static Book book = new Book(ISBN, TITLE, AUTOR, AMOUNT, PICK_PERIOD);
	static Reader reader = new Reader(READER_ID, NAME, PHONE, BIRTH_DATE);
	static ILibrary library;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		library = new LibraryMaps();
		library.addBookItem(book);
		library.addBookExemplars(ISBN, AMOUNT);
		library.addReader(reader);
		((Persistable) library).save(FILE_NAME);

	}

	@Before
	public void setUp() throws Exception {
		library = LibraryMaps.restoreFromFile(FILE_NAME);
	}

	@Test
	public void testGetter() {
		Book actualBook = library.getBookItem(ISBN);
		assertEquals(book, actualBook);
		Reader actualReader = library.getReader(READER_ID);
		assertEquals(reader, actualReader);

	}

}
