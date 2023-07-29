package telran.library.entities;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class Book implements Serializable {
	private long isbn;
	private String title;
	private String autor;
	private int amount;
	private int amountInUse;
	private int picPeriod;

	public Book() {
	}

	public Book(long isbn, String title, String autor, int amount, int picPeriod) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.autor = autor;
		this.amount = amount;
		this.picPeriod = picPeriod;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmountInUse() {
		return amountInUse;
	}

	public void setAmountInUse(int amountInUse) {
		this.amountInUse = amountInUse;
	}

	public int getPicPeriod() {
		return picPeriod;
	}

	public void setPicPeriod(int picPeriod) {
		this.picPeriod = picPeriod;
	}

	public long getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAutor() {
		return autor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		return isbn == other.isbn;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", autor=" + autor + ", amount=" + amount + ", amountInUse="
				+ amountInUse + ", picPeriod=" + picPeriod + "]";
	}

}
