package persons.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
public class Employee extends Person{
    private String company;

    public Employee(final int id, final String name, final Address address, final LocalDate birthDate, final String company) {
        super(id, name, address, birthDate);
        this.company = company;
    }
}
