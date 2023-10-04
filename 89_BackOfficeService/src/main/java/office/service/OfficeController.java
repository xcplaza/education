package office.service;

//import office.repo.Repos;
import office.repo.Repos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OfficeController implements IBackOffice{

    @Autowired
    Repos repo;

    @Override
    public List<Integer> getIdBigValues(final LocalDateTime from, final LocalDateTime to, final int normalValue) {
        return repo.getIdsByAvgValueGreaterThan(from, to, normalValue);
    }

    @Override
    public List<Integer> getIdSmallValues(final LocalDateTime from, final LocalDateTime to, final int normalValue) {
        return repo.getIdsByAvgValueLessThan(from, to, normalValue);
    }

    @Override
    public List<LocalDateTime> getDatesBigValues(final int sensorId, final int normalValue, final LocalDateTime from, final LocalDateTime to) {
        return repo.getDatesBySensorIdAndAvgValueGreaterThan(sensorId, normalValue, from, to);
    }

    @Override
    public List<LocalDateTime> getDatesSmallValues(final int sensorId, final int normalValue, final LocalDateTime from, final LocalDateTime to) {
        return repo.getDatesBySensorIdAndAvgValueLessThan(sensorId, normalValue, from, to);
    }

//    @Override
//    public SensorStatistics getSensorStatistics(final int sensorId, final LocalDateTime from, final LocalDateTime to) {
//        // Здесь реализуйте логику для получения статистики по сенсору
//        // Например, вы можете использовать репозиторий для получения необходимых данных и
//        // создать объект SensorStatistics, содержащий нужную информацию.
//        // Возвращайте этот объект собственной логики.
//        return null;
//    }
}
