package cars.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "cars")
@Entity
@Table(name = "owners")
public class Owner {
    @Id
    public int id;
    public String name;
    public int birthYear;

    @ManyToMany(mappedBy = "owners", fetch = FetchType.EAGER) // fetch = FetchType.EAGER - политика кеширования
    public List<Car> cars;
}
