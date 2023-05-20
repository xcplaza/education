
public class Manager extends Employee {
	int grade; // меняется от 1 до 6

	public Manager() {
	}

	public Manager(String name, int age, boolean married, String company, String position, double baseSalary,
			int grade) {
		super(name, age, married, company, position, baseSalary);
		if (grade >= 1 && grade <= 6)
			this.grade = grade;
		else {
			System.out.println("No grade!");
		}
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		if (grade >= 1 && grade <= 6)
			this.grade = grade;
	}

	public void display() {
		String str = ("Grade: " + grade + "\n=================================\n");
		System.out.println(str);
	}

	public double calculateSalary() {
		return baseSalary * grade;
	}

	@Override
	public String toString() {
		return super.toString() + ", Grade: " + grade;
	}
}
