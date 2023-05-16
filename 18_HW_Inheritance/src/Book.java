
public class Book {
	String autor;
	String nameBook;
	int pages;

	public Book() {
	};

	public Book(String autor, String nameBook, int pages) {
		super();
		if (autor != null && !autor.isEmpty())
			this.autor = autor;
		else {
			this.autor = "No autor!";
		}
		if (nameBook != null && !nameBook.isEmpty())
			this.nameBook = nameBook;
		else {
			this.nameBook = "No nameBook!";
		}
		if (pages >= 1)
			this.pages = pages;
		else {
			this.pages = -1;
		}
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if (autor != null && !autor.isBlank())
			this.autor = autor;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		if (nameBook != null && !nameBook.isEmpty())
			this.nameBook = nameBook;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		if (pages >= 1)
			this.pages = pages;
	}

	@Override
	public String toString() {
		return "Autor: " + autor + ", NameBook: " + nameBook + ", Pages: " + pages;
	}
}
