package telran.dto;

import java.util.Objects;
import telran.intrf.IPrintable;

public class Journal extends MassMedia implements IPrintable {

	int issueNumber;
	int numberOfPages;
	boolean glossy;
	int circulation;

	public Journal() {
	}

	public int getIssueNumb() {
		return issueNumber;
	}

	public void setIssueNumb(int issueNumb) {
		this.issueNumber = issueNumb;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public boolean isGlossy() {
		return glossy;
	}

	public void setGlossy(boolean glossy) {
		this.glossy = glossy;
	}

	public int getCirculation() {
		return circulation;
	}

	public void setCirculation(int circulation) {
		this.circulation = circulation;
	}

	public Journal(String name, int issueNumb, int numberOfPages, boolean glossy, int circulation) {
		super(name);
		this.issueNumber = issueNumb;
		this.numberOfPages = numberOfPages;
		this.glossy = glossy;
		this.circulation = circulation;
	}

	@Override
	public String toString() {
		return "Journal [name=" + name + ", issueNumb=" + issueNumber + ", numberOfPages=" + numberOfPages + ", glossy="
				+ glossy + ", circulation=" + circulation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(circulation, glossy, issueNumber, numberOfPages);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Journal))
			return false;
		Journal other = (Journal) obj;
		return circulation == other.circulation && glossy == other.glossy && issueNumber == other.issueNumber
				&& numberOfPages == other.numberOfPages;
	}

	@Override
	public int getRating() {
		double rating = (double) circulation / 9291000 * 10;
		return (int) Math.min(rating, 10);
	}

	@Override
	public void print() {
        System.out.println("Journal: " + name);
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Number of Pages: " + numberOfPages);
        System.out.println("Glossy: " + glossy);
        System.out.println("Circulation: " + circulation);
        System.out.println("Rating: " + getRating());
        System.out.println();
	}

}
