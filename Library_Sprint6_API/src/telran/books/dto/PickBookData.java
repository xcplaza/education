package telran.books.dto;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class PickBookData implements Serializable{
	long isbn;
	int readerId;
	LocalDate rentDate;
	
	public PickBookData() {
	}

	public PickBookData(long isbn, int readerId, LocalDate rentDate) {
		super();
		this.isbn = isbn;
		this.readerId = readerId;
		this.rentDate = rentDate;
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

	public LocalDate getRentDate() {
		return rentDate;
	}

	public void setRentDate(LocalDate rentDate) {
		this.rentDate = rentDate;
	}

	@Override
	public String toString() {
		return "PickBookData [isbn=" + isbn + ", readerId=" + readerId + ", rentDate=" + rentDate + "]";
	}

}
