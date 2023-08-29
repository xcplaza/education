package persons;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@SuppressWarnings("serial")
public class Child extends Person {

	String garten;

	public Child(int id, String name, LocalDate birthDate, Address address, String garten) {
		super(id, name, birthDate, address);
		this.garten = garten;
	}

	@Override
	public String toString() {
		return "Child [garten=" + garten + "]" + super.toString();
	}

}
