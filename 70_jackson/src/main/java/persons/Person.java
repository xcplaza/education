package persons;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@SuppressWarnings("serial")
@JsonTypeInfo(use = Id.CLASS)
public class Person implements Serializable {
	int id;
	String name;

	@JsonFormat(pattern = "dd/MM/yyyy")
	LocalDate birthDate;
//	transient boolean bool; // transient  -  запрет на serialization
	Address address;

	public Person(int id, String name, LocalDate birthDate, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", address=" + address + "]";
	}

}
