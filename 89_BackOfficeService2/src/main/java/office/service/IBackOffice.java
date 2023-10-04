package office.service;

import java.time.LocalDateTime;
import java.util.List;

public interface IBackOffice {
    List<Integer> getIdBigValues(LocalDateTime from, LocalDateTime to, int normalValue);
    List<Integer> getIdSmallValues(LocalDateTime from, LocalDateTime to, int normalValue);
    List<LocalDateTime> getDatesBigValues(int sensorId, int normalValue, LocalDateTime from, LocalDateTime to);
    List<LocalDateTime> getDatesSmallValues(int sensorId, int normalValue, LocalDateTime from, LocalDateTime to);
    SensorStatistics getSensorStatistics(int sensorId, LocalDateTime from, LocalDateTime to);
}
