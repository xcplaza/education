package office.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SensorStatistics {
    private double averageValue;
    private int maxValue;
    private int minValue;
}
