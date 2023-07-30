package telran.library.model;

import telran.library.entities.Book;
import telran.library.entities.BooksReturnCode;
import telran.library.entities.PickRecord;
import telran.library.entities.Reader;
import telran.utils.Persistable;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class LibraryMaps extends AbstractLibrary implements Persistable {
	HashMap<Long, Book> books = new HashMap<>();
	HashMap<Integer, Reader> readers = new HashMap<>();
//	Sprint2
	HashMap<Long, List<PickRecord>> bookRecords = new HashMap<>();
	HashMap<Integer, List<PickRecord>> readerRecords = new HashMap<>();
	HashMap<String, List<Book>> authorBooks = new HashMap<>();
	TreeMap<LocalDate, List<PickRecord>> records = new TreeMap<>();

	@Override
	public BooksReturnCode addBookItem(Book book) {
		if (book.getPickPeriod() < minPickPeriod)
			return BooksReturnCode.PICK_PERIOD_LESS_MIN;
		if (book.getPickPeriod() > maxPickPeriod)
			return BooksReturnCode.PICK_PERIOD_GREATER_MAX;
		return books.putIfAbsent(book.getIsbn(), book) == null ? BooksReturnCode.OK : BooksReturnCode.BOOK_ITEM_EXISTS;
	}

	@Override
	public BooksReturnCode addReader(Reader reader) {
		return readers.putIfAbsent(reader.getReaderId(), reader) == null ? BooksReturnCode.OK
				: BooksReturnCode.READER_EXISTS;
	}

	@Override
	public BooksReturnCode addBookExemplars(long isbn, int amount) {
		Book book = getBookItem(isbn);
		if (book == null)
			return BooksReturnCode.NO_BOOK_ITEM;
		book.setAmount(book.getAmount() + amount);
		return BooksReturnCode.OK;
	}

	@Override
	public Reader getReader(int reader) {
		return readers.get(reader);
	}

	@Override
	public Book getBookItem(long isbn) {
		return books.get(isbn);
	}

	@Override
	public void save(String fileName) {
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName))) {
			output.writeObject(this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
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

//	Sprint2
	@Override
	public BooksReturnCode pickBook(long isbn, int readerId, LocalDate pickDate) {
		Book book = getBookItem(isbn);
		if (book == null)
			return BooksReturnCode.NO_BOOK_ITEM;
		if (book.getAmountInUse() == book.getAmount())
			return BooksReturnCode.NO_BOOK_EXEMPLARS;
		if (!readers.containsKey(readerId))
			return BooksReturnCode.READER_EXISTS;
		PickRecord record = new PickRecord(isbn, readerId, pickDate);
		addToBookRecord(record);
		addToReaderRecord(record);
		addToRecords(record);
		book.setAmountInUse(book.getAmountInUse()+1);

		return BooksReturnCode.OK;

//		RentRecord record = new RentRecord(regNumber, licenseId, rentDate, rentDays);
//		addToCarRecord(record);
//		addToDriverRecords(record);
//		addToRecords(record);
//		car.setInUse(true);
//		return CarsRetunCode.OK;
	}

	private void addToRecords(PickRecord record) {
		long isbnBook = record.getIsbn();
		List<PickRecord> listRecords = bookRecords.getOrDefault(isbnBook, new ArrayList<>());
		listRecords.add(record);
		bookRecords.putIfAbsent(isbnBook, listRecords);
	}

	private void addToReaderRecord(PickRecord record) {
		long readerId = record.getReaderId();
		List<PickRecord> listRecords = readerRecords.getOrDefault(readerId, new ArrayList<>());
		listRecords.add(record);
		readerRecords.putIfAbsent((int) readerId, listRecords);
	}

	private void addToBookRecord(PickRecord record) {
		LocalDate rentBook = record.getPickDate();
		List<PickRecord> listRecords = records.getOrDefault(rentBook, new ArrayList<>());
		listRecords.add(record);
		records.putIfAbsent(rentBook, listRecords);
	}

	@Override
	public List<Book> getBooksPickedByReader(int readerId) {
		List<PickRecord> listRecord = bookRecords.getOrDefault(readerId, new ArrayList<>());
		return listRecord.stream().map(r -> getBookItem(r.getReaderId())).distinct().toList();
	}

	@Override
	public List<Reader> getReadersPickedBook(long isbn) {
		List<PickRecord> listReaders = readerRecords.getOrDefault(isbn, new ArrayList<>());
		return listReaders.stream().map(r -> getReader(r.getReaderId())).distinct().toList();
	}

	@Override
	public List<Book> getBooksAuthor(String authorName) {
		List<Book> listAuthor = authorBooks.getOrDefault(authorName, new ArrayList<>());
		return listAuthor.stream().filter(b -> b.getAuthor().equals(authorName)).distinct().toList();
	}

	@Override
	public List<PickRecord> getPickRecordsAtDates(LocalDate from, LocalDate to) {
		Collection<List<PickRecord>> collRecords = records.subMap(from, to).values();
		return collRecords.stream().flatMap(l -> l.stream()).toList();
	}
}
