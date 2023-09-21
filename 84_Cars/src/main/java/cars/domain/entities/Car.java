package cars.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    public LocalDate purchaseDate;

    @ManyToOne
//    @ManyToOne(cascade = CascadeType.ALL) // включаем каскад удаления авто при удалении модели
    public Model model;
    @ManyToOne
    public Owner owner;
}
