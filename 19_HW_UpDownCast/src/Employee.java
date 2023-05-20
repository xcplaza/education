
public class Employee extends Person {
	String company;
	String position;
	double baseSalary;

	public Employee() {
	}

	public Employee(String name, int age, boolean married, String company, String position, double baseSalary) {
		super(name, age, married);
		if (company != null && !company.isBlank())
			this.company = company;
		else {
			System.out.println("No company!");
		}
		if (position != null & !position.isBlank())
			this.position = position;
		else {
			System.out.println("No position!");
		}
		if (baseSalary > 0)
			this.baseSalary = baseSalary;
		else {
			System.out.println("No base salary!");
		}

	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		if (company != null && !company.isBlank())
			this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		if (position != null & !position.isBlank())
			this.position = position;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		if (baseSalary > 0)
			this.baseSalary = baseSalary;
	}

	public void display() {
		String str = ("Company: " + company + "\nPosition: " + position + "\nBaseSalary: " + baseSalary
				+ "\n=================================\n");
		System.out.println(str);
	}

	@Override
	public String toString() {
		return super.toString() + ", Company: " + company + ", Position: " + position + ", BaseSalary: " + baseSalary;
	}
}
