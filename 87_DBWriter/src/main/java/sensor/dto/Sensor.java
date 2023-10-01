package sensor.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Sensor {
    public long timestamp;
    public int serNumber;
    public int id;
    public int value;

    public Sensor(long timestamp, int id, int value) {
        this.timestamp = timestamp;
        this.id = id;
        this.value = value;
    }
}
