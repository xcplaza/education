package telran.library.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import telran.library.entities.Book;
import telran.library.entities.BooksReturnCode;
import telran.library.entities.PickRecord;
import telran.library.entities.Reader;
import telran.library.entities.RemovedBookData;

public interface ILibrary extends Serializable
{
//	Sprint1
	BooksReturnCode addBookItem(Book book);
	BooksReturnCode addReader(Reader reader);
	BooksReturnCode addBookExemplars(long isbn, int amount);
	Reader getReader(int reader);
	Book getBookItem(long isbn);
	
//	Sprint2
	BooksReturnCode pickBook(long isbn, int readerId, LocalDate rentDate);
	List<Book> getBooksPickedByReader(int readerId);
	List<Reader> getReadersPickedBook(long isbn);
	List<Book> getBooksAuthor(String authorName);
	List<PickRecord> getPickedRecordsAtDates(LocalDate from, LocalDate to);
	
//	Sprint3
	RemovedBookData removeBook(long isbn); 
	List<RemovedBookData> removeAuthor(String author);
	RemovedBookData returnBook(long isbn,int readerId,LocalDate returnDate);
}