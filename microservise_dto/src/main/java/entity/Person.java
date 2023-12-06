package entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "persons")
@NoArgsConstructor
public class Person {
    @Id
    long id;
    @Column(nullable = false, unique = true)
    String email;
    String name;
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    Sensor sensor;
}
