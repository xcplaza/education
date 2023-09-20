package persons.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable

//    класс - если требуется 2 поля для ID
public class IdName {
    private int id;
    private String name;
}
