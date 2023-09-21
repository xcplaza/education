package cars.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "models") //задаем имя таблицы
public class Model {
    @Id
    public String modelName;
    public int volume;
    public String company;
}
