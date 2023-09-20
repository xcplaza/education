package persons.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
public class Child extends Person{
    private String garten;

    public Child(int id, String name, Address address, LocalDate birthDate, String garten) {
        super(id, name, address, birthDate);
        this.garten = garten;
    }
}
