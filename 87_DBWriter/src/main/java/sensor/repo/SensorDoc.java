package sensor.repo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Document(collation = "sensors")
public class SensorDoc {
    public int patientId;
    public int avgValue;
    public long timestamp;
}
