package persons.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@ToString
@Entity
public class Person {
    @Id
    private int id;
    private String name;

    @Setter
    private Address address;
    private LocalDate birthDate;
}
