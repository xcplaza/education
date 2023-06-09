import java.util.Objects;

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
	
	public double calculateSalary() { // добавляем для обхода DownCast (абстрактный метод) чтобы он проходил через другие объекты
		return 0.0;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(baseSalary, company, position);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		return Double.doubleToLongBits(baseSalary) == Double.doubleToLongBits(other.baseSalary)
				&& Objects.equals(company, other.company) && Objects.equals(position, other.position);
	}
}
