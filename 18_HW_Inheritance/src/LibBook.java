
public class LibBook extends Book {
	int catNumber;

	public LibBook() {
	}

	public LibBook(String autor, String nameBook, int pages, int catNumber) {
		super(autor, nameBook, pages);
		if (catNumber >= 0 && catNumber <= 999999)
			this.catNumber = catNumber;
		else {
			this.catNumber = -1;
		}
	}

	public int getCatNumber() {
		return catNumber;
	}

	public void setCatNumber(int catNumber) {
		if (catNumber >= 0 && catNumber <= 999999)
			this.catNumber = catNumber;
	}

	@Override
	public String toString() {
		return super.toString() + ", Catalog number: " + catNumber;
	}

}
