
public class TestBook {

	public static void main(String[] args) {

		FictionBook fb = new FictionBook("name1", "autor1", 123, 123456, "genge1");

//		==========================upperCasting
		Book b2 = new EducationBook("name2", "autor2", 45, 198765, "genge2", "subject2");
		Book b = new FictionBook("name1", "autor1", 123, 123456, "genge1");
		ChildFictionBook b3 = new ChildFictionBook("name3", "autor3", 233, 987654, "genge3", 14);
		ChildFictionBook b4 = new ChildFictionBook("name4", "autor3", 567, 547689, "genge3", 10);
		ChildFictionBook b5 = new ChildFictionBook("name5", "autor3", 143, 345221, "genge3", 7);
		Book[] books = { fb, b2, b3, b4, b5 }; // создаем массив и он делает upCasting
		System.out.println(books[0].toString());

//		==========================downCasting
//		b2.getSubject();
		EducationBook test = (EducationBook) b2;
		System.out.println(test.getSubject());

//		Error - Class Cast Exception
//		EducationBook test2 = (EducationBook) b;
//		LibBook test3 = (LibBook) new Book("name1", "autor1", 123);

		double age = avgAgeChildBooks(books);
		System.out.println(age);

		if (books[4] instanceof ChildFictionBook) // instanceof - проверяет является ли объект books порождением класса
													// ChildFictionBook
			System.out.println("Hello");

		System.out.println(books[4].getClass());
	}

//	средний возраст детской литературы
	private static double avgAgeChildBooks(Book[] books) {
		double sum = 0;
		int count = 0;
		for (int i = 0; i < books.length; i++) {
			if (books[i] instanceof ChildFictionBook) {
				ChildFictionBook temp = (ChildFictionBook) books[i]; // downCast
				sum += temp.getAge();
				count++; // считаем количество таких книг
			}
		}
		return sum / count;
	}
}
