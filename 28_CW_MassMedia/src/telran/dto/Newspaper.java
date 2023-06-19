package telran.dto;

import java.util.Objects;
import telran.intrf.IPrintable;

public class Newspaper extends MassMedia implements IPrintable {

	int issueNumber;
	int numberOfPages;
	int circulation;

	public Newspaper() {
	}

	public Newspaper(String name, int issueNumber, int numberOfPages, int circulation) {
		super(name);
		this.issueNumber = issueNumber;
		this.numberOfPages = numberOfPages;
		this.circulation = circulation;
	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public int getCirculation() {
		return circulation;
	}

	public void setCirculation(int circulation) {
		this.circulation = circulation;
	}

	@Override
	public String toString() {
		return "Newspaper [name=" + name + ", issueNumber=" + issueNumber + ", numberOfPages=" + numberOfPages
				+ ", circulation=" + circulation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(circulation, issueNumber, numberOfPages);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Newspaper))
			return false;
		Newspaper other = (Newspaper) obj;
		return circulation == other.circulation && issueNumber == other.issueNumber
				&& numberOfPages == other.numberOfPages;
	}

	@Override
	public int getRating() {
		double rating = (double) circulation / 9291000 * 10;
		return (int) Math.min(rating, 10);
	}

	@Override
	public void print() {
		System.out.println("Newspaper: " + name);
		System.out.println("Issue Number: " + issueNumber);
		System.out.println("Number of Pages: " + numberOfPages);
		System.out.println("Circulation: " + circulation);
		System.out.println("Rating: " + getRating());
		System.out.println();
	}

}
