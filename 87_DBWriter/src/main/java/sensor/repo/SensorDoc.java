package sensor.repo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "sensors")
public class SensorDoc
{
    public int patientId;
    public int avgValue;
    public long timestamp;
}
