package practice;

public class Employeer {
	String name;
	String company;
	int salary;

	public Employeer(String name, String company, int salary) {
		super();
		this.name = name;
		this.company = company;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employeer [name=" + name + ", company=" + company + ", salary=" + salary + "]";
	}

}
