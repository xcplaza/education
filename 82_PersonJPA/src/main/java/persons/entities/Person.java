package persons.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
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

//    если требуется 2 поля для ID
//    @EmbeddedId
//    private IdName key;

    @Setter
    @Embedded
    private Address address;
    private LocalDate birthDate;
}
