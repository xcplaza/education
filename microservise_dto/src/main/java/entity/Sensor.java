package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sensors")
public class Sensor {
    @Id
    long id;
    String purpose;
    double minValue;
    double maxValue;
}
