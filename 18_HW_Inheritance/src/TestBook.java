
public class TestBook {

	public static void main(String[] args) {

		FictionBook[] fb = { new FictionBook("Rowling", "Harry Potter", 336, 123456, "Fantasy"),
				new FictionBook("John", "Mathematics", 546, 234567, "Education"),
				new FictionBook("Tolkien", "Ring", 1248, 345678, "Fantasy"),
				new FictionBook("Lev Tolstoy", "War & Mir", 785, 456789, "Education"),
				new FictionBook("Pushkin", "Poems", 159, 567890, "Education"),
				new FictionBook("Hokking", "Space", 852, 678901, "Sciense") };

		EducationBook[] eb = { new EducationBook("Rowling", "Harry Potter", 336, 123456, "Fantasy", "Sub1"),
				new EducationBook("John", "Mathematics", 546, 234567, "Education", "Sub2"),
				new EducationBook("Tolkien", "Ring", 1248, 345678, "Fantasy", "Sub3"),
				new EducationBook("Lev Tolstoy", "War & Mir", 785, 456789, "Education", "Sub4"),
				new EducationBook("Pushkin", "Poems", 159, 567890, "Education", "Sub5"),
				new EducationBook("Hokking", "Space", 852, 678901, "Sciense", "Sub6") };

		fBooks(fb);
		System.out.println("\n---------------------------\n");
		fBooks(eb);
	}

	private static void fBooks(FictionBook[] fb) {
		for (int i = 0; i <= fb.length - 1; i++)
			if (fb[i] != null)
				System.out.println(fb[i].toString());
	}
}
