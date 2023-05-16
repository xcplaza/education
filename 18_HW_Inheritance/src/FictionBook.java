
public class FictionBook extends LibBook {
	String genge;

	public FictionBook() {
	}

	public FictionBook(String autor, String nameBook, int pages, int catNumber, String genge) {
		super(autor, nameBook, pages, catNumber);
		if (genge != null && !genge.isEmpty())
			this.genge = genge;
		else {
			this.genge = "No Genge!";
		}
	}

	public String getGenge() {
		return genge;
	}

	public void setGenge(String genge) {
		if (genge != null && !genge.isEmpty())
			this.genge = genge;
	}

	@Override
	public String toString() {
		return super.toString() + ", Genge: " + genge;
	}

}
