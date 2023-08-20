package telran.books.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BookExemplarsData implements Serializable {
	long isbn;
	int amount;

	public BookExemplarsData() {
	}

	public BookExemplarsData(long isbn, int amount) {
		super();
		this.isbn = isbn;
		this.amount = amount;
	}

	public long getIsbn() {
		return isbn;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "BookExemplarsData [isbn=" + isbn + ", amount=" + amount + "]";
	}
	
	

}
