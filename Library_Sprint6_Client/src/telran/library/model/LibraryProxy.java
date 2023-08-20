package telran.library.model;

import java.time.LocalDate;
import java.util.List;

import static telran.books.api.ApiConstants.*;
import telran.books.model.*;
import telran.books.dto.*;
import telran.net.TCPClientJava;

@SuppressWarnings("serial")
public class LibraryProxy extends TCPClientJava implements ILibrary {

	public LibraryProxy(String hostname, int port) throws Exception {
		super(hostname, port);
	}

	@Override
	public BooksReturnCode addBookItem(Book book) {
		return sendRequestGetResponse(ADD_BOOK, book);
	}

	@Override
	public BooksReturnCode addReader(Reader reader) {
		return sendRequestGetResponse(ADD_READER, reader);
	}

	@Override
	public BooksReturnCode addBookExemplars(long isbn, int amount) {

		return sendRequestGetResponse(ADD_EXEMPLARS, new BookExemplarsData(isbn, amount));
	}

	@Override
	public Reader getReader(int reader) {
		return sendRequestGetResponse(GET_READER, reader);
	}

	@Override
	public Book getBookItem(long isbn) {
		return sendRequestGetResponse(GET_BOOK, isbn);
	}

	@Override
	public BooksReturnCode pickBook(long isbn, int readerId, LocalDate rentDate) {
		return sendRequestGetResponse(ADD_BOOK, new PickBookData(isbn, readerId, rentDate));
	}

	@Override
	public List<Book> getBooksPickedByReader(int readerId) {
		return sendRequestGetResponse(GET_BOOKS_PICKED_READER, readerId);
	}

	@Override
	public List<Reader> getReadersPickedBook(long isbn) {
		return sendRequestGetResponse(GET_READERS_PICKED_BOOK, isbn);
	}

	@Override
	public List<Book> getBooksAuthor(String authorName) {
		return sendRequestGetResponse(GET_BOOKS_AUTHOR, authorName);
	}

	@Override
	public List<PickRecord> getPickedRecordsAtDates(LocalDate from, LocalDate to) {
		LocalDate[] ld = { from, to };
		return sendRequestGetResponse(GET_PICKED_RECORDS_DATES, ld);
	}

	@Override
	public RemovedBookData removeBook(long isbn) {
		return sendRequestGetResponse(REMOVE_BOOK, isbn);
	}

	@Override
	public List<RemovedBookData> removeAuthor(String author) {
		return sendRequestGetResponse(REMOVE_AUTHOR, author);
	}

	@Override
	public RemovedBookData returnBook(long isbn, int readerId, LocalDate returnDate) {
		return sendRequestGetResponse(RETURN_BOOK, new ReturnBookData(isbn, readerId, returnDate));
	}

	@Override
	public List<ReaderDelay> getReadersDelayingBooks(LocalDate currentDate) {
		return sendRequestGetResponse(GET_READERS_DELAYING_BOOKS, currentDate);
	}

	@Override
	public List<ReaderDelay> getReadersDelayedBooks() {
		return sendRequestGetResponse(ADD_EXEMPLARS, null);
	}

	@Override
	public List<Book> getMostPopularBooks(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge) {
		return sendRequestGetResponse(GET_MOST_POPULAR_BOOKS, new StatisticBookData(fromDate, toDate, fromAge, toAge));
	}

	@Override
	public List<String> getMostPopularAuthors() {
		return sendRequestGetResponse(GET_MOST_POPULAR_AUTHORS, null);
	}

	@Override
	public List<Reader> getMostActiveReaders(LocalDate fromDate, LocalDate toDate) {
		return sendRequestGetResponse(GET_MOST_ACTIVE_READERS, new StatisticBookData(fromDate, toDate, 1, 100));
	}

	@Override
	public List<String> getAuthors() {
		return sendRequestGetResponse(GET_AUTHORS, null);
	}

}
