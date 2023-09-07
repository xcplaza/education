package person.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@SuppressWarnings("serial")
public class Child extends Person {

	public String garten;

	public Child(int id, String name, LocalDate birthDate, Address address, String garten) {
		super(id, name, birthDate, address);
		this.garten = garten;
	}

	@Override
	public String toString() {
		return "Child [garten=" + garten + "]" + super.toString();
	}

}
