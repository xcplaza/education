package telran.library.model;

import java.io.Serializable;
import telran.library.entities.Book;
import telran.library.entities.BooksReturnCode;
import telran.library.entities.Reader;

public interface ILibrary extends Serializable {
	BooksReturnCode addBookItem(Book book);
	BooksReturnCode addReader(Reader reader);
	Reader getReader(int readerId);
	Book getBookItem(long isbn);
	BooksReturnCode addBookExemplars(long isbn, int amount);
}
