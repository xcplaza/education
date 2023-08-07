package telran.employees.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class Employee implements Serializable {
	private int id;
	private String name;
	private String companyName;
	private int salary;
	
	public Employee() {}

	public Employee(int id, String name, String companyName, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.companyName = companyName;
		this.salary = salary;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", companyName=" + companyName + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		return id == other.id;
	}
	
	
}
