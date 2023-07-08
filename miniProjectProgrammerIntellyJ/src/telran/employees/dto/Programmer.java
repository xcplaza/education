package telran.employees.dto;

import java.util.Objects;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class Programmer {
	int id;
	String name;
	Set<String> technologies;
	int salary;

	public Programmer() {
	}

	public Programmer(int id, String name, String[] technologies, int salary) {
		if (id < 0 || name == null || technologies == null || salary < 0)
			return;
		this.id = id;
		this.name = name;
		this.technologies = new HashSet<String>(Arrays.asList(technologies));
		this.salary = salary;
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

	public Set<String> getTechnologies() {
		return technologies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, salary, technologies);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Programmer))
			return false;
		Programmer other = (Programmer) obj;
		return id == other.id && Objects.equals(name, other.name) && salary == other.salary
				&& Objects.equals(technologies, other.technologies);
	}

	@Override
	public String toString() {
		return "Programmer [id=" + id + ", name=" + name + ", technologies=" + technologies + ", salary=" + salary
				+ "]";
	}

}
