package cars.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
//@Table(name = "cars", indexes = @Index(columnList = "color"))
@Table(name = "cars", indexes = {@Index(columnList = "color, purchaseDate")})
public class Car {
    @Id
    @Column(name = "req_number", length = 10, unique = true, nullable = false)
    public long regNumber;
    public String color;
    @Setter
    @Getter
    public LocalDate purchaseDate;

    @ManyToOne
//    @ManyToMany
    public Model model;
    @ManyToMany
    @Setter
    @Getter
    @JoinTable(name = "car_owner", joinColumns = @JoinColumn(name = "car_reg_number"), inverseJoinColumns = @JoinColumn(name = "owner_id"))
    public List<Owner> owners;
}
