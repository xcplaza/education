package telran.library.model;

import telran.library.entities.Book;
import telran.library.entities.BooksReturnCode;
import telran.library.entities.Reader;
import telran.utils.Persistable;

import java.io.*;
import java.util.HashMap;

@SuppressWarnings("serial")
public class LibraryMaps extends AbstractLibrary implements Persistable
{
	HashMap<Long, Book> books = new HashMap<>();
	HashMap<Integer, Reader> readers = new HashMap<>();

	@Override
	public BooksReturnCode addBookItem(Book book)
	{
		if (book.getPickPeriod() < minPickPeriod)
			return BooksReturnCode.PICK_PERIOD_LESS_MIN;
		if (book.getPickPeriod() > maxPickPeriod)
			return BooksReturnCode.PICK_PERIOD_GREATER_MAX;
		return books.putIfAbsent(book.getIsbn(), book) == null ? BooksReturnCode.OK : 
			BooksReturnCode.BOOK_ITEM_EXISTS;
	}

	@Override
	public BooksReturnCode addReader(Reader reader)
	{
		return readers.putIfAbsent(reader.getReaderId(), reader) == null ? BooksReturnCode.OK
				: BooksReturnCode.READER_EXISTS;
	}

	@Override
	public BooksReturnCode addBookExemplars(long isbn, int amount)
	{
		Book book = getBookItem(isbn);
		if (book == null)
			return BooksReturnCode.NO_BOOK_ITEM;
		book.setAmount(book.getAmount() + amount);
		return BooksReturnCode.OK;
	}
	
	@Override
	public Reader getReader(int reader)
	{
		return readers.get(reader);
	}

	@Override
	public Book getBookItem(long isbn)
	{
		return books.get(isbn);
	}

	@Override
	public void save(String fileName)
	{
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			output.writeObject(this);
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static ILibrary restoreFromFile(String fileName)
	{
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName)))
		{
			return (LibraryMaps) input.readObject();
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return new LibraryMaps();
		}
	}
}
