package telran.books.model;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;

import telran.books.dto.Book;
import telran.books.dto.BookExemplarsData;
import telran.books.dto.BooksReturnCode;
import telran.books.dto.PickBookData;
import telran.books.dto.Reader;
import telran.books.dto.ReturnBookData;
import telran.books.dto.StatisticBookData;
import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TCPResponseCode;
import telran.server.ProtocolJava;

@SuppressWarnings("unused")
public class LibraryProtocol implements ProtocolJava {
	ILibrary service;

	public LibraryProtocol(ILibrary service) {
		super();
		this.service = service;
	}

	@Override
	public ResponseJava getResponse(RequestJava request) {
		String type = request.requestType;
		Serializable data = request.requestData;

		try {
			Class<?> clazz = this.getClass();
			String methodName = type.replaceAll("/", "_");
			Method m = clazz.getDeclaredMethod(methodName, Serializable.class);
			m.setAccessible(true);
			return (ResponseJava) m.invoke(this, data);

		} catch (Exception e) {
			return wrongRequest(e.getMessage());
		}
	}

	private ResponseJava wrongRequest(String message) {
		return new ResponseJava(TCPResponseCode.UNKNOWN, message);
	}

	private ResponseJava _book_add(Serializable data) {
		Book book = (Book) data;
		BooksReturnCode res = service.addBookItem(book);
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _reader_add(Serializable data) {
		Reader reader = (Reader) data;
		BooksReturnCode res = service.addReader(reader);
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _exemplars_add(Serializable data) {
		BookExemplarsData book = (BookExemplarsData) data;
		BooksReturnCode res = service.addBookExemplars(book.getIsbn(), book.getAmount());
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _reader(Serializable data) {
		Integer reader = (Integer) data;
		Reader res = service.getReader(reader);
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _book(Serializable data) {
		Long isbn = (Long) data;
		Book res = service.getBookItem(isbn);
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _book_pick(Serializable data) {
		PickBookData pb = (PickBookData) data;
		BooksReturnCode res = service.pickBook(pb.getIsbn(), pb.getReaderId(), pb.getRentDate());
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _readers_books(Serializable data) {
		int readerId = (int) data;
		Serializable res = (Serializable) service.getBooksPickedByReader(readerId);
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _book_readers(Serializable data) {
		long isbn = (long) data;
		Serializable res = (Serializable) service.getReadersPickedBook(isbn);
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _author(Serializable data) {
		String authorName = (String) data;
		Serializable res = (Serializable) service.getBooksAuthor(authorName);
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _records_picked(Serializable data) {
		LocalDate[] ld = (LocalDate[]) data;
		Serializable res = (Serializable) service.getPickedRecordsAtDates(ld[0], ld[1]);
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _book_remove(Serializable data) {
		long isbn = (long) data;
		Serializable res = (Serializable) service.removeBook(isbn);
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _author_remove(Serializable data) {
		String author = (String) data;
		Serializable res = (Serializable) service.removeAuthor(null);
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _book_return(Serializable data) {
		ReturnBookData dataTemp = (ReturnBookData) data;

		Serializable res = (Serializable) service.returnBook(dataTemp.getIsbn(), dataTemp.getReaderId(),
				dataTemp.getReturnDate());
		return new ResponseJava(TCPResponseCode.OK, res);
	}

	private ResponseJava _readers_delaying(Serializable data) {
		LocalDate ld = (LocalDate) data;
		Serializable responseData = (Serializable) service.getReadersDelayingBooks(ld);
		return new ResponseJava(TCPResponseCode.OK, responseData);

	}

	private ResponseJava _readers_delayed(Serializable data) {
		Serializable responseData = (Serializable) service.getReadersDelayedBooks();
		return new ResponseJava(TCPResponseCode.OK, responseData);

	}

	private ResponseJava _books_popular(Serializable data) {
		StatisticBookData sbd = (StatisticBookData) data;
		Serializable responseData = (Serializable) service.getMostPopularBooks(sbd.getFromDate(), sbd.getToDate(),
				sbd.getFromAge(), sbd.getToAge());
		return new ResponseJava(TCPResponseCode.OK, responseData);
	}

	private ResponseJava _authors_popular(Serializable data) {
		Serializable responseData = (Serializable) service.getMostPopularAuthors();
		return new ResponseJava(TCPResponseCode.OK, responseData);
	}

	private ResponseJava _readers_active(Serializable data) {
		StatisticBookData sbd = (StatisticBookData) data;

		Serializable responseData = (Serializable) service.getMostActiveReaders(sbd.getFromDate(), sbd.getToDate());

		return new ResponseJava(TCPResponseCode.OK, responseData);
	}

	private ResponseJava _authors(Serializable data) {
		Serializable responseData = (Serializable) service.getAuthors();
		return new ResponseJava(TCPResponseCode.OK, responseData);
	}

}
