package cars.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
//@Table(name = "cars", indexes = @Index(columnList = "color"))
@Table(name = "cars", indexes = {@Index(columnList = "color, purchaseDate")})
public class Car {
    @Id
    @Column(name = "reg_number", length = 10, unique = true, nullable = false)
    public long regNumber;
    public String color;
    @Setter
    @Getter
    public LocalDate purchaseDate;

    @ManyToOne
//    @ManyToOne(cascade = CascadeType.ALL) // включаем каскад удаления авто при удалении модели
    public Model model;
    @ManyToOne
    @Setter
    @Getter
    public Owner owner;
}
