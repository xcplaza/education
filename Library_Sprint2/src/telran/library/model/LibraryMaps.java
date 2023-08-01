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
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class LibraryMaps extends AbstractLibrary implements Persistable
{
	HashMap<Long, Book> books = new HashMap<>();
	HashMap<Integer, Reader> readers = new HashMap<>();
	
	HashMap<Long, List<PickRecord>> bookRecords = new HashMap<>();
	HashMap<Integer, List<PickRecord>> readerRecords = new HashMap<>();
	TreeMap<LocalDate, List<PickRecord>> records = new TreeMap<>();
	HashMap<String, List<Book>> authorBooks = new HashMap<>();

	@Override
	public BooksReturnCode addBookItem(Book book)
	{
		if (book.getPickPeriod() < minPickPeriod)
			return BooksReturnCode.PICK_PERIOD_LESS_MIN;
		if (book.getPickPeriod() > maxPickPeriod)
			return BooksReturnCode.PICK_PERIOD_GREATER_MAX;
		
		BooksReturnCode res = books.putIfAbsent(book.getIsbn(), book) == null ?  
				BooksReturnCode.OK : BooksReturnCode.BOOK_ITEM_EXISTS;
		if (res == BooksReturnCode.OK)
			addToMap(authorBooks, book.getAuthor(), book);
		return res;
	}
	
	private <K, V> void addToMap(Map<K, List<V>> map, K key, V value) 
	{
		map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
	}
	
//	private <K, V> void addMethod_v2(K t, AbstractMap<K, List<V>> map, V record) {
//	map.compute(t, (k, v) -> {
//		(v = v == null ? new ArrayList<>() : v).add(record);
//		return v;
//	});
//}
	
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

	public static LibraryMaps restoreFromFile(String fileName)
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
	
	@Override
	public BooksReturnCode pickBook(long isbn, int readerId, LocalDate pickDate)
	{
		Book book = books.get(isbn);
		if (book == null || book.getAmount() < 0)// removed book marked as negative amount value
			return BooksReturnCode.NO_BOOK_ITEM;
		if (book.getAmount() == book.getAmountInUse())
			return BooksReturnCode.NO_BOOK_EXEMPLARS;
		if (!readers.containsKey(readerId))
			return BooksReturnCode.NO_READER;
		
		List<PickRecord> pickRecords = readerRecords.get(readerId);
		if (pickRecords != null && pickRecords.stream().anyMatch(r -> r.getIsbn() == isbn && r.getReturnDate() == null))
			return BooksReturnCode.READER_READS_IT;
		
		PickRecord record = new PickRecord(isbn, readerId, pickDate);
		addToMap(bookRecords, record.getIsbn(), record);
		addToMap(readerRecords, record.getReaderId(), record);
		addToMap(records, record.getPickDate(), record);
		
		book.setAmountInUse(book.getAmountInUse() + 1);
		return BooksReturnCode.OK;
	}
	
	@Override
	public List<Book> getBooksPickedByReader(int readerId)
	{
		List<PickRecord> recordsList = readerRecords.getOrDefault(readerId, new ArrayList<>());
		return recordsList.stream().map(r -> getBookItem(r.getIsbn())).distinct().toList();
	}

	@Override
	public List<Reader> getReadersPickedBook(long isbn)
	{
		List<PickRecord> recordsList = bookRecords.getOrDefault(isbn, new ArrayList<>());
		return recordsList.stream().map(r -> getReader(r.getReaderId())).distinct().toList();
	}

	@Override
	public List<Book> getBooksAuthor(String authorName)
	{
		List<Book> res = authorBooks.getOrDefault(authorName, new ArrayList<>());
		return res.stream().filter(b -> b.getAmount() > b.getAmountInUse()).toList();
	}

	@Override
	public List<PickRecord> getPickedRecordsAtDates(LocalDate from, LocalDate to)
	{
		Collection<List<PickRecord>> recordsList = records.subMap(from, to).values();
		return recordsList == null ? new ArrayList<>() : recordsList.stream().flatMap(List::stream).toList();
	}
}
