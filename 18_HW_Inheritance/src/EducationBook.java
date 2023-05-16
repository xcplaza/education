
public class EducationBook extends FictionBook {
	String subject;

	public EducationBook() {
	}

	public EducationBook(String autor, String nameBook, int pages, int catNumber, String genge, String subject) {
		super(autor, nameBook, pages, catNumber, genge);
		if (subject != null && !subject.isEmpty())
			this.subject = subject;
		else {
			this.subject = "No Subject!";
		}
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		if (subject != null && !subject.isEmpty())
			this.subject = subject;
	}

	@Override
	public String toString() {
		return super.toString() + ", Subject: " + subject;
	}

}
