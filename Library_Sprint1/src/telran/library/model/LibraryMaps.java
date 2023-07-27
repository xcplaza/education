package telran.library.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import telran.library.entities.*;
import telran.util.Persistable;

@SuppressWarnings("serial")
public class LibraryMaps extends AbstractLibrary implements Persistable {
	HashMap<Long, Book> books = new HashMap<>();
	HashMap<Integer, Reader> readers = new HashMap<>();

	@Override
	public BooksReturnCode addBookItem(Book book) {
		if (book.getPicPeriod() < this.minPickPeriod) {
			return BooksReturnCode.PICK_PERIOD_LASS_MIN;
		}
		if (book.getPicPeriod() > this.maxPickPeriod) {
			return BooksReturnCode.PICK_PERIOD_CREATOR_MAX;
		}
		return books.putIfAbsent(book.getIsbn(), book) == null ? BooksReturnCode.OK : BooksReturnCode.BOOK_ITEM_EXIST;
	}

	@Override
	public BooksReturnCode addReader(Reader reader) {
		return readers.putIfAbsent(reader.getReaderId(), reader) == null ? BooksReturnCode.OK
				: BooksReturnCode.READER_EXIST;
	}

	@Override
	public Reader getReader(int readerId) {
		return readers.get(readerId);
	}

	@Override
	public Book getBookItem(long isbn) {
		return books.get(isbn);
	}

	@Override
	public BooksReturnCode addBookExemplars(long isbn, int amount) {
		if (!books.containsKey(isbn))
			return BooksReturnCode.NO_BOOK_ITEM;
		books.get(isbn).setAmount(books.get(isbn).getAmount() + amount);
		return BooksReturnCode.OK;
	}

	@Override
	public void save(String fileName) {
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName))) {
			output.writeObject(this);
		} catch (Exception e) {
			System.out.println("Error in method save " + e.getMessage());
		}
	}

	public static ILibrary restoreFromFile(String fileName) {
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
			return (LibraryMaps) input.readObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new LibraryMaps();
		}
	}
}
