
public class ChildFictionBook extends FictionBook {
	int age;

	public ChildFictionBook() {
	}

	public ChildFictionBook(String autor, String nameBook, int pages, int catNumber, String genge, int age) {
		super(autor, nameBook, pages, catNumber, genge);
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ChildFictionBook [genge=" + genge + ", catNumber=" + catNumber + ", autor=" + autor + ", nameBook="
				+ nameBook + ", pages=" + pages + ", age=" + age + "]";
	}
	
	

}
