package persons;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@SuppressWarnings("serial")
public class Employee extends Person {
	String company;
	int salary;
	String title;

	public Employee(int id, String name, LocalDate birthDate, Address address, String company, int salary,
			String title) {
		super(id, name, birthDate, address);
		this.company = company;
		this.salary = salary;
		this.title = title;
	}

	@Override
	public String toString() {
		return "Employee [company=" + company + ", salary=" + salary + ", title=" + title + "]" + super.toString();
	}

}
