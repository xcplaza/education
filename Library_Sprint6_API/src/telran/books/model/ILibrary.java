package telran.books.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import telran.books.dto.*;
import telran.books.dto.BooksReturnCode;

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
	
//	Sprint4
	List<ReaderDelay> getReadersDelayingBooks(LocalDate currentDate); 
	//list of readers ordered by total delay on current date (they have not returned yet)
	List<ReaderDelay> getReadersDelayedBooks(); 
	//list of readers ordered by total delay of all returned books (they returned but with a delay)
	List<Book> getMostPopularBooks(LocalDate fromDate,LocalDate toDate, int fromAge,int toAge);
	List<String> getMostPopularAuthors();
	List<Reader> getMostActiveReaders(LocalDate fromDate,LocalDate toDate);
	
//	sprint5
	List<String> getAuthors();
}
