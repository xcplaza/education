package telran.books.dto;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class ReturnBookData implements Serializable {

  long isbn;
  int readerId;
  LocalDate returnDate;

  public ReturnBookData() {
  }

  public ReturnBookData(long isbn, int readerId, LocalDate returnDate) {
    super();
    this.isbn = isbn;
    this.readerId = readerId;
    this.returnDate = returnDate;
  }

  public long getIsbn() {
    return isbn;
  }

  public void setIsbn(long isbn) {
    this.isbn = isbn;
  }

  public int getReaderId() {
    return readerId;
  }

  public void setReaderId(int readerId) {
    this.readerId = readerId;
  }

  public LocalDate getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
  }

}
