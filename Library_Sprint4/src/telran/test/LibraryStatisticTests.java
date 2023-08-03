package telran.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import telran.library.entities.Book;
import telran.library.entities.Reader;
import telran.library.entities.ReaderDelay;
import telran.library.model.*;

public class LibraryStatisticTests
{
	private static final int PICK_DAYS = 8;
	private static final int PICK_PERIOD = 3;
	private static final int AMOUNT = 100;

	ILibrary library = new LibraryMaps();

	String[] authors = { "author0", "author0", "author1", "author1", "author2" };

	LocalDate[] dates = { LocalDate.of(1970, 1, 1), LocalDate.of(1965, 1, 1), LocalDate.of(2000, 1, 1),
			LocalDate.of(2001, 10, 10) };
	
	int[] booksIsbn = {0, 1, 0, 1, 2, 2, 3, 4};
	int[] readersId = {0, 0, 1, 1, 2, 3, 0, 0};
//	Delays
//	reader0 -> 5 + 4 + 2 + 1 = 12
//	reader1 -> 5 + 4 = 9
//	reader2 -> 3 
//	reader3 -> 3
	int[] expDelay = {12, 9, 3, 3};

	@Before
	public void setUp() throws Exception
	{
		createBooks();
		createReaders();
		pickBooks();
	}

	private void createBooks()
	{
		for (int i = 0; i < authors.length; i++)
		{
			library.addBookItem(new Book(i, "title", authors[i], AMOUNT, PICK_PERIOD + i));
		}
	}

	private void createReaders()
	{
		for (int i = 0; i < dates.length; i++)
		{
			library.addReader(new Reader(i, "name", "phone", dates[i]));
		}
	}
	
	private void pickBooks()
	{
		for (int i = 0; i < booksIsbn.length; i++)
		{
			library.pickBook(booksIsbn[i], readersId[i], LocalDate.now());
		}
	}
	
	private void returnBooks()
	{
		for (int i = 0; i < booksIsbn.length; i++)
		{
			library.returnBook(booksIsbn[i], readersId[i], LocalDate.now().plusDays(PICK_DAYS));
		}
	}
	
	@Test
	public void testGetReadersDelayingBooks()
	{
		List<ReaderDelay> readerDelays = library.getReadersDelayingBooks(LocalDate.now().plusDays(PICK_DAYS));
		testReaderDelays(expDelay, readerDelays);
		returnBooks();
		// after returning no delaying books
		readerDelays = library.getReadersDelayingBooks(LocalDate.now().plusDays(PICK_DAYS));
		assertTrue(readerDelays.isEmpty());
	}

	private void testReaderDelays(int[] ed, List<ReaderDelay> rd)
	{
		for (int i=0; i<ed.length; i++)
		{
			assertEquals(ed[i], rd.get(i).getDelay());
		}
	}

	@Test
	public void testGetReadersDelayedBooks()
	{
		List<ReaderDelay> readerDelays = library.getReadersDelayedBooks();
		assertTrue(readerDelays.isEmpty());
		returnBooks();
		readerDelays = library.getReadersDelayedBooks();
		testReaderDelays(expDelay, readerDelays);
	}

	@Test
	public void testGetMostPopularBooks()
	{
		List<Book> popularBooks50_70 = library.getMostPopularBooks(LocalDate.now(),
				LocalDate.now().plusDays(PICK_DAYS + 1), 50, 70);
		List<Book> popularBooks15_25 = library.getMostPopularBooks(LocalDate.now(),
				LocalDate.now().plusDays(PICK_DAYS + 1), 15, 25);
		// Most popular book among young people is books 2
		assertEquals(1, popularBooks15_25.size());
		assertEquals(2, popularBooks15_25.get(0).getIsbn());
		// Most popular books among older people are books 0 and books 1
		assertEquals(2, popularBooks50_70.size());
		assertTrue(popularBooks50_70.contains(library.getBookItem(0)));
		assertTrue(popularBooks50_70.contains(library.getBookItem(1)));
	}

	@Test
	public void testGetMostPopularAuthors()
	{
		List<String> popularAuthors = library.getMostPopularAuthors();
		// most popular author is authors[0]
		assertEquals(1, popularAuthors.size());
		assertEquals(authors[0], popularAuthors.get(0));
	}

	@Test
	public void testGetMostActiveReaders()
	{
		List<Reader> activeReaders = library.getMostActiveReaders(LocalDate.now(), LocalDate.now().plusDays(PICK_DAYS + 1));
		// most active reader is readers 0
		assertEquals(1, activeReaders.size());
		assertEquals(0, activeReaders.get(0).getReaderId());
	}
}
