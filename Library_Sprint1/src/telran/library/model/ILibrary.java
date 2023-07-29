package telran.library.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import telran.library.entities.Book;
import telran.library.entities.BooksReturnCode;
import telran.library.entities.Reader;

public interface ILibrary extends Serializable {
	BooksReturnCode addBookItem(Book book);
	BooksReturnCode addReader(Reader reader);
	BooksReturnCode addBookExemplars(long isbn, int amount);
	Reader getReader(int reader);
	Book getBookItem(long isbn);
}
