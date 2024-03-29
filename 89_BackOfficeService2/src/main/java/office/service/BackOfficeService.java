package office.service;

import office.entity.SensorDocRepository;
import office.repos.Repos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
@RestController
public class BackOfficeService implements IBackOffice {
    private final Repos sensorDocRepository;

    @Autowired
    public BackOfficeService(Repos sensorDocRepository) {
        this.sensorDocRepository = sensorDocRepository;
    }

    @Override
    public List<Integer> getIdBigValues(LocalDateTime from, LocalDateTime to, int normalValue) {
        List<Integer> result = new ArrayList<>();
        List<SensorDocRepository> sensorDocs = sensorDocRepository.findByTimestampBetweenAndAvgValueGreaterThan(
                from.toEpochSecond(ZoneOffset.UTC) * 1000,
                to.toEpochSecond(ZoneOffset.UTC) * 1000,
                normalValue);
        for (SensorDocRepository sensorDoc : sensorDocs) {
            result.add(sensorDoc.getPatientId());
        }
        return result;
    }

    @Override
    public List<Integer> getIdSmallValues(LocalDateTime from, LocalDateTime to, int normalValue) {
        List<Integer> result = new ArrayList<>();
        List<SensorDocRepository> sensorDocs = sensorDocRepository.findByTimestampBetweenAndAvgValueLessThan(
                from.toEpochSecond(ZoneOffset.UTC) * 1000,
                to.toEpochSecond(ZoneOffset.UTC) * 1000,
                normalValue);
        for (SensorDocRepository sensorDoc : sensorDocs) {
            result.add(sensorDoc.getPatientId());
        }
        return result;
    }

    @Override
    public List<LocalDateTime> getDatesBigValues(int sensorId, int normalValue, LocalDateTime from, LocalDateTime to) {
        List<LocalDateTime> result = new ArrayList<>();
        List<SensorDocRepository> sensorDocs = sensorDocRepository.findByPatientIdAndTimestampBetweenAndAvgValueGreaterThan(
                String.valueOf(sensorId),
                from.toEpochSecond(ZoneOffset.UTC) * 1000,
                to.toEpochSecond(ZoneOffset.UTC) * 1000,
                normalValue);
        for (SensorDocRepository sensorDoc : sensorDocs) {
            result.add(LocalDateTime.ofEpochSecond(sensorDoc.getTimestamp() / 1000, 0, ZoneOffset.UTC));
        }
        return result;
    }

    @Override
    public List<LocalDateTime> getDatesSmallValues(int sensorId, int normalValue, LocalDateTime from, LocalDateTime to) {
        List<LocalDateTime> result = new ArrayList<>();
        List<SensorDocRepository> sensorDocs = sensorDocRepository.findByPatientIdAndTimestampBetweenAndAvgValueLessThan(
                String.valueOf(sensorId),
                from.toEpochSecond(ZoneOffset.UTC) * 1000,
                to.toEpochSecond(ZoneOffset.UTC) * 1000,
                normalValue);
        for (SensorDocRepository sensorDoc : sensorDocs) {
            result.add(LocalDateTime.ofEpochSecond(sensorDoc.getTimestamp() / 1000, 0, ZoneOffset.UTC));
        }
        return result;
    }

    @Override
    public SensorStatistics getSensorStatistics(int sensorId, LocalDateTime from, LocalDateTime to) {
        List<SensorDocRepository> sensorDocs = sensorDocRepository.findByPatientIdAndTimestampBetween(
                String.valueOf(sensorId),
                from.toEpochSecond(ZoneOffset.UTC) * 1000,
                to.toEpochSecond(ZoneOffset.UTC) * 1000);
        if (sensorDocs.isEmpty()) {
            return null; // Если не найдено данных
        }

        double sumValue = 0;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for (SensorDocRepository sensorDoc : sensorDocs) {
            int avgValue = sensorDoc.getAvgValue();
            sumValue += avgValue;
            if (avgValue > maxValue) {
                maxValue = avgValue;
            }
            if (avgValue < minValue) {
                minValue = avgValue;
            }
        }
        double averageValue = sumValue / sensorDocs.size();
        return new SensorStatistics(averageValue, maxValue, minValue);
    }
}
