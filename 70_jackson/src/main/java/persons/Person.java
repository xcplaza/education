package persons;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@SuppressWarnings("serial")

// type:child
@JsonTypeInfo(use = Id.NAME, property = "type")
@JsonSubTypes({ @Type(value = Person.class, name = "person"), @Type(value = Child.class, name = "child"),
		@Type(value = Employee.class, name = "employee") })
@JsonIgnoreProperties(ignoreUnknown = true)

//@JsonTypeInfo(use = Id.CLASS) // "@class" : "persons.Employee" - JSON
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
