package office.entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
//@Entity
@Document(collection = "sensors")
public class Patient {
    @Id
    private int sensorId;
    @Getter
    private int avgValue;
    @Getter
    private long timestamp;
}
