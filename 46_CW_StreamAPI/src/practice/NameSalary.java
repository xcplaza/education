package practice;

public class NameSalary {
	String name;
	int salary;

	public NameSalary(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return name + " -> " + salary;
	}

}
