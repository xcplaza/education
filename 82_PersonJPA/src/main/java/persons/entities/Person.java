package persons.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@ToString
//разбиваем на поля для sql
@Entity
//делаем 3 таблицы в sql для зависимых объектов (дублирование информации в таблицах)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//делаем 3 таблицы в sql для зависимых объектов + relation
@Inheritance(strategy = InheritanceType.JOINED)

public class Person {
    @Id
    private int id;
    @Setter
    private String name;

//    если требуется 2 поля для ID
//    @EmbeddedId
//    private IdName key;

    @Setter
    @Embedded
    private Address address;
    private LocalDate birthDate;
}
