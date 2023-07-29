package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.library.entities.Book;
import telran.library.entities.BooksReturnCode;
import telran.library.entities.Reader;
import telran.library.model.ILibrary;
import telran.library.model.LibraryMaps;
import telran.utils.Persistable;

class LibraryMapsTest
{
	private static final long ISBN1 = 123;
	private static final String TITLE1 = "Java for Dummies";
	private static final int PICK_PIRIOD1 = 30;
	private static final int PICK_PERIOD_LESS_MIN = 2;
	private static final int PICK_PERIOD_GREATER_MAX = 40;
	private static final int AMOUNT1 = 500;
	private static final String AUTHOR1 = "Dummy";
	private static final String PHONE1 = "1234567";
	private static final int READER_ID1 = 123;
	static Book book1 = new Book(ISBN1, TITLE1, AUTHOR1, AMOUNT1, PICK_PIRIOD1);
	private static final LocalDate BIRTH_DATE1= LocalDate.ofYearDay(1980, 100);
	private static final String NAME1="Vasya";
	

	static Reader reader1 = new Reader(READER_ID1, NAME1, PHONE1, BIRTH_DATE1);
	static ILibrary library;

	@BeforeAll
	static void setUpBeforeClass() throws Exception
	{
		library = new LibraryMaps();
		library.addReader(reader1);
		library.addBookItem(book1);
		((Persistable) library).save("library.book");
	}

	@BeforeEach
	void setUp() throws Exception
	{
		library = LibraryMaps.restoreFromFile("library.book");
	}

	@Test
	void testAddBookItem()
	{
		assertEquals(BooksReturnCode.BOOK_ITEM_EXISTS, library.addBookItem(book1));
		Book book2=new Book(ISBN1-1, "title", "author", 10, PICK_PERIOD_LESS_MIN);
		assertEquals(BooksReturnCode.PICK_PERIOD_LESS_MIN, library.addBookItem(book2));
		book2=new Book(ISBN1-1, "title", "author", 10, PICK_PERIOD_GREATER_MAX);
		assertEquals(BooksReturnCode.PICK_PERIOD_GREATER_MAX, library.addBookItem(book2));
		book2=new Book(ISBN1-1, "title", "author", 10, 20);
		assertEquals(BooksReturnCode.OK, library.addBookItem(book2));
	}

	@Test
	void testAddReader()
	{
		Reader reader2=new Reader(READER_ID1-1, "name", "phone", BIRTH_DATE1);
		assertEquals(BooksReturnCode.READER_EXISTS, library.addReader(reader1));
		assertEquals(BooksReturnCode.OK, library.addReader(reader2));
	}

	@Test
	void testAddBookExemplars()
	{
		int amount=10;
		assertEquals(BooksReturnCode.NO_BOOK_ITEM,
				library.addBookExemplars(ISBN1-1,amount));
		assertEquals(BooksReturnCode.OK,
				library.addBookExemplars(ISBN1,amount));
		assertEquals(AMOUNT1+amount,
				library.getBookItem(ISBN1).getAmount());
	}

	@Test
	void testGetReader()
	{
		Reader actualReader = library.getReader(READER_ID1);
		assertEquals(reader1, actualReader);
	}

	@Test
	void testGetBookItem()
	{
		Book actualBook = library.getBookItem(ISBN1);
		assertEquals(book1, actualBook);
	}

}
