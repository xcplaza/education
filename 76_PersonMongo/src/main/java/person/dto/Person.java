package person.dto;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Document(collection = "persons")
@SuppressWarnings("serial")

public class Person implements Serializable {

    @Id
    public int id;
    public String name;

    @Indexed
    public LocalDate birthDate;
    public Address address;

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
