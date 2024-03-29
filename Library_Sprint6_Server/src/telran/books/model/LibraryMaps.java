package telran.books.model;

import telran.books.dto.*;
import telran.books.dto.BooksReturnCode;
import telran.books.dto.PickRecord;
import telran.books.dto.Reader;
import telran.books.dto.ReaderDelay;
import telran.books.dto.RemovedBookData;
import telran.utils.Persistable;
import static telran.books.model.LibraryLocks.*;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.stream.Collectors;

@SuppressWarnings("serial")
public class LibraryMaps extends AbstractLibrary implements Persistable {
	private static final LocalDate dateFrom = LocalDate.of(2000, 1, 1);
	HashMap<Long, Book> books = new HashMap<>();
	HashMap<Integer, Reader> readers = new HashMap<>();

	HashMap<Long, List<PickRecord>> bookRecords = new HashMap<>();
	HashMap<Integer, List<PickRecord>> readerRecords = new HashMap<>();
	TreeMap<LocalDate, List<PickRecord>> records = new TreeMap<>();
	HashMap<String, List<Book>> authorBooks = new HashMap<>();

	@Override
	public BooksReturnCode addBookItem(Book book) {
		lockUnlock_addBookItem(true);
		try {
			if (book.getPickPeriod() < minPickPeriod)
				return BooksReturnCode.PICK_PERIOD_LESS_MIN;
			if (book.getPickPeriod() > maxPickPeriod)
				return BooksReturnCode.PICK_PERIOD_GREATER_MAX;
			BooksReturnCode res = books.putIfAbsent(book.getIsbn(), book) == null ? BooksReturnCode.OK
					: BooksReturnCode.BOOK_ITEM_EXISTS;
			if (res == BooksReturnCode.OK)
				addToMap(authorBooks, book.getAuthor(), book);
			return res;
		} finally {
			lockUnlock_addBookItem(false);
		}
	}

	private <K, V> void addToMap(Map<K, List<V>> map, K key, V value) {
		map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
	}

	@Override
	public BooksReturnCode addReader(Reader reader) {
		lockUnlock_addReader(true);
		try {
			return readers.putIfAbsent(reader.getReaderId(), reader) == null ? BooksReturnCode.OK
					: BooksReturnCode.READER_EXISTS;
		} finally {
			lockUnlock_addReader(false);
		}
	}

	@Override
	public BooksReturnCode addBookExemplars(long isbn, int amount) {
		lockUnlock_addBookExemplars(true);
		try {
			Book book = getBookItem(isbn);
			if (book == null)
				return BooksReturnCode.NO_BOOK_ITEM;
			book.setAmount(book.getAmount() + amount);
			return BooksReturnCode.OK;
		} finally {
			lockUnlock_addBookExemplars(false);
		}
	}

	@Override
	public Reader getReader(int reader) {
		lockUnlock_getReader(true);
		try {
			if (readers.containsKey(reader)) {
				return readers.get(reader);
			} else {
				// Либо вернуть null, либо выбросить исключение, чтобы сигнализировать о
				// проблеме.
				// return null;
				throw new NoSuchElementException("Reader with id " + reader + " not found.");
			} 
		} finally {
			lockUnlock_getReader(false);
		}
	}

	@Override
	public Book getBookItem(long isbn) {
		lockUnlock_getBookItem(true);
		try {
			return books.get(isbn);
		} finally {
			lockUnlock_getBookItem(false);
		}
	}

	@Override
	public void save(String fileName) {
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName))) {
			output.writeObject(this);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static LibraryMaps restoreFromFile(String fileName) {
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
			return (LibraryMaps) input.readObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new LibraryMaps();
		}
	}

	@Override
	public BooksReturnCode pickBook(long isbn, int readerId, LocalDate pickDate) {
		lockUnlock_pickBook(true);
		try {
			Book book = books.get(isbn);
			if (book == null || book.getAmount() < 0)// removed book marked as negative amount value
				return BooksReturnCode.NO_BOOK_ITEM;
			if (book.getAmount() == book.getAmountInUse())
				return BooksReturnCode.NO_BOOK_EXEMPLARS;
			if (!readers.containsKey(readerId))
				return BooksReturnCode.NO_READER;
			List<PickRecord> pickRecords = readerRecords.get(readerId);
			if (pickRecords != null
					&& pickRecords.stream().anyMatch(r -> r.getIsbn() == isbn && r.getReturnDate() == null))
				return BooksReturnCode.READER_READS_IT;
			PickRecord record = new PickRecord(isbn, readerId, pickDate);
			addToMap(bookRecords, record.getIsbn(), record);
			addToMap(readerRecords, record.getReaderId(), record);
			addToMap(records, record.getPickDate(), record);
			book.setAmountInUse(book.getAmountInUse() + 1);
			return BooksReturnCode.OK;
		} finally {
			lockUnlock_pickBook(false);
		}
	}

	@Override
	public List<Book> getBooksPickedByReader(int readerId) {
		lockUnlock_getBooksPickedByReader(true);
		try {
			List<PickRecord> recordsList = readerRecords.getOrDefault(readerId, new ArrayList<>());
			return recordsList.stream().map(r -> getBookItem(r.getIsbn())).distinct().toList();
		} finally {
			lockUnlock_getBooksPickedByReader(false);
		}
	}

	@Override
	public List<Reader> getReadersPickedBook(long isbn) {
		lockUnlock_getReadersPickedBook(true);
		try {
			List<PickRecord> recordsList = bookRecords.getOrDefault(isbn, new ArrayList<>());
			return recordsList.stream().map(r -> getReader(r.getReaderId())).distinct().toList();
		} finally {
			lockUnlock_getReadersPickedBook(false);
		}
	}

	@Override
	public List<Book> getBooksAuthor(String authorName) {
		lockUnlock_getBooksAuthor(true);
		try {
			List<Book> res = authorBooks.getOrDefault(authorName, new ArrayList<>());
			return res.stream().filter(b -> b.getAmount() > b.getAmountInUse()).toList();
		} finally {
			lockUnlock_getBooksAuthor(false);
		}
	}

	@Override
	public List<PickRecord> getPickedRecordsAtDates(LocalDate from, LocalDate to) {
		lockUnlock_getPickedRecordsAtDates(true);
		try {
			Collection<List<PickRecord>> recordsList = records.subMap(from, to).values();
			return recordsList == null ? new ArrayList<>() : recordsList.stream().flatMap(List::stream).toList();
		} finally {
			lockUnlock_getPickedRecordsAtDates(false);
		}
	}

	@Override
	public RemovedBookData removeBook(long isbn) {
		lockUnlock_removeBook(true);
		try {
			Book book = getBookItem(isbn);
			if (book == null || book.getAmount() < 0/* sign of a removed book */)
				return null;
			RemovedBookData rbd;
			if (book.getAmountInUse() > 0) {
				book.setAmount(-1);// sign of the book item removed
				rbd = new RemovedBookData(book, null);
			} else {
				List<PickRecord> removedRecords = actualBookRemove(isbn);
				rbd = new RemovedBookData(book, removedRecords);
			}
			return rbd;
		} finally {
			lockUnlock_removeBook(false);
		}
	}

	private List<PickRecord> actualBookRemove(long isbn) {
		List<PickRecord> recordsForRemove = bookRecords.getOrDefault(isbn, new ArrayList<>());
		recordsForRemove.forEach(this::removeRecordFromMaps);
		// removeBookFromAuthors(isbn);
//		this method causes issue in removeAuthor but it isn't needed
		// as the method getBooksAuthor doesn't return removed books
		Book book = getBookItem(isbn);
		authorBooks.get(book.getAuthor()).remove(book);
		books.remove(isbn);
		return recordsForRemove;
	}

	private void removeRecordFromMaps(PickRecord record) {
		long isbn = record.getIsbn();
		bookRecords.remove(isbn);

		LocalDate pickDate = record.getPickDate();
		records.get(pickDate).remove(record);

		int readerId = record.getReaderId();
		readerRecords.get(readerId).remove(record);
	}

	@Override
	public List<RemovedBookData> removeAuthor(String author) {
		lockUnlock_removeAuthor(true);
		try {
			List<Book> booksList = authorBooks.getOrDefault(author, new ArrayList<>());
			List<RemovedBookData> res = new ArrayList<>();
			booksList.forEach(b -> res.add(removeBook(b.getIsbn())));
			return res;
		} finally {
			lockUnlock_removeAuthor(false);
		}
	}

	@Override
	public RemovedBookData returnBook(long isbn, int readerId, LocalDate returnDate) {
		lockUnlock_returnBook(true);
		try {
			List<PickRecord> recordsList = readerRecords.get(readerId);
			if (recordsList == null)
				return null;
			PickRecord record = recordsList.stream().filter(r -> r.getIsbn() == isbn && r.getReturnDate() == null)
					.findFirst().orElse(null);
			if (record == null)
				return null;
			Book book = getBookItem(isbn);
			updateRecord(returnDate, record, book);
			RemovedBookData rbd = updateBook(isbn, book);
			return rbd;
		} finally {
			lockUnlock_returnBook(false);
		}
	}

	private RemovedBookData updateBook(long isbn, Book book) {
		RemovedBookData rbd;
		book.setAmountInUse(book.getAmountInUse() - 1);
		if (book.getAmount() < 0 && book.getAmountInUse() == 0)
			rbd = new RemovedBookData(book, actualBookRemove(isbn));
		else
			rbd = new RemovedBookData(book, null);
		return rbd;
	}

	private void updateRecord(LocalDate returnDate, PickRecord record, Book book) {
		record.setReturnDate(returnDate);
		int actualDays = (int) ChronoUnit.DAYS.between(record.getPickDate(), returnDate);
		int delay = actualDays - book.getPickPeriod();
		if (delay > 0)
			record.setDelayDays(delay);
	}

	// Sprint4
	@Override
	public List<ReaderDelay> getReadersDelayingBooks(LocalDate currentDate) {
		lockUnlock_getReadersDelayingBooks(true);
		try {
			List<PickRecord> possibleDelaying = getPickedRecordsAtDates(dateFrom, currentDate.minusDays(minPickPeriod));
			Map<Reader, Integer> readersTotalDelay = possibleDelaying.stream()
					.filter(r -> r.getReturnDate() == null || r.getReturnDate().isAfter(currentDate))
					.map(r -> getReaderDelay(r, currentDate)).filter(rd -> rd.getDelay() > 0)
					.collect(Collectors.groupingBy(rd -> rd.getReader(), Collectors.summingInt(rd -> rd.getDelay())));
			return getList(readersTotalDelay);
		} finally {
			lockUnlock_getReadersDelayingBooks(false);
		}
	}

	private ReaderDelay getReaderDelay(PickRecord record, LocalDate currentDate) {
		int delay = (int) (ChronoUnit.DAYS.between(record.getPickDate(), currentDate)
				- getBookItem(record.getIsbn()).getPickPeriod());
		return new ReaderDelay(getReader(record.getReaderId()), delay);
	}

	private List<ReaderDelay> getList(Map<Reader, Integer> readers) {
		List<ReaderDelay> res = new ArrayList<>();
		readers.forEach((k, v) -> res.add(new ReaderDelay(k, v)));
		res.sort((rd1, rd2) -> Integer.compare(rd2.getDelay(), rd1.getDelay()));
		return res;
	}

	@Override
	public List<ReaderDelay> getReadersDelayedBooks() {
		lockUnlock_getReadersDelayedBooks(true);
		try {
			Map<Reader, Integer> readersTotalDelay = records.values().stream().flatMap(List::stream)
					.filter(r -> r.getReturnDate() != null && r.getDelayDays() > 0)
					.map(r -> new ReaderDelay(getReader(r.getReaderId()), r.getDelayDays()))
					.collect(Collectors.groupingBy(rd -> rd.getReader(), Collectors.summingInt(rd -> rd.getDelay())));
			return getList(readersTotalDelay);
		} finally {
			lockUnlock_getReadersDelayedBooks(false);
		}
	}

	@Override
	public List<Book> getMostPopularBooks(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge) {
		lockUnlock_getMostPopularBooks(true);
		try {
			Map<Long, Long> isbnCount = getPickedRecordsAtDates(fromDate, toDate).stream()
					.filter(r -> isAgeInRange(r, fromAge, toAge))
					.collect(Collectors.groupingBy(PickRecord::getIsbn, Collectors.counting()));
			if (isbnCount.isEmpty())
				return new ArrayList<>();
			long max = Collections.max(isbnCount.values());
			List<Book> res = new ArrayList<>();
			isbnCount.forEach((k, v) -> {
				if (v == max)
					res.add(getBookItem(k));
			});
			return res;
		} finally {
			lockUnlock_getMostPopularBooks(false);
		}
	}

	private boolean isAgeInRange(PickRecord r, int fromAge, int toAge) {
		Reader reader = getReader(r.getReaderId());
		// age at the pickDate date
		int age = (int) ChronoUnit.YEARS.between(reader.getBirthData(), r.getPickDate());
		return age >= fromAge && age < toAge;
	}

	@Override
	public List<String> getMostPopularAuthors() {
		lockUnlock_getMostPopularAuthors(true);
		try {
			Map<String, Long> authorCount = records.values().stream().flatMap(List::stream)
					.collect(Collectors.groupingBy(r -> getBookItem(r.getIsbn()).getAuthor(), Collectors.counting()));
			long max = Collections.max(authorCount.values());
			List<String> res = new ArrayList<>();
			authorCount.forEach((k, v) -> {
				if (v == max)
					res.add(k);
			});
			return res;
		} finally {
			lockUnlock_getMostPopularAuthors(false);
		}
	}

	@Override
	public List<Reader> getMostActiveReaders(LocalDate fromDate, LocalDate toDate) {
		lockUnlock_getMostActiveReaders(true);
		try {
			List<PickRecord> recordsByPeriod = getPickedRecordsAtDates(fromDate, toDate);
			Map<Integer, Long> readerIdCount = recordsByPeriod.stream()
					.collect(Collectors.groupingBy(PickRecord::getReaderId, Collectors.counting()));
			long max = Collections.max(readerIdCount.values());
			List<Reader> res = new ArrayList<>();
			readerIdCount.forEach((k, v) -> {
				if (v == max)
					res.add(getReader(k));
			});
			return res;
		} finally {
			lockUnlock_getMostActiveReaders(false);
		}
	}

	public List<String> getAuthors() {
		lockUnlock_getAuthors(true);
		try {
			return new ArrayList<>(authorBooks.keySet());
		} finally {
			lockUnlock_getAuthors(false);
		}
	}
}
