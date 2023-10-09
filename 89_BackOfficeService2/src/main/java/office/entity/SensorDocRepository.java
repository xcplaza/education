package office.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sensors")
public class SensorDocRepository {
    @Id
    private String id;
    private int patientId;
    @Getter
    @Setter
    private int avgValue;
    @Getter
    @Setter
    private long timestamp;

    public int getPatientId() {
        return patientId;
    }
}
