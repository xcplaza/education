package cars.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "cars")
public class Car {
    @Id
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
