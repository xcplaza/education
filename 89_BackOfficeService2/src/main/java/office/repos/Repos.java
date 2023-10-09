package office.repos;
import office.entity.SensorDocRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface Repos extends MongoRepository<SensorDocRepository, String> {
    List<SensorDocRepository> findByTimestampBetweenAndAvgValueGreaterThan(long l, long l1, int normalValue);
    List<SensorDocRepository> findByTimestampBetweenAndAvgValueLessThan(long l, long l1, int normalValue);
    List<SensorDocRepository> findByPatientIdAndTimestampBetweenAndAvgValueGreaterThan(String s, long l, long l1, int normalValue);
    List<SensorDocRepository> findByPatientIdAndTimestampBetweenAndAvgValueLessThan(String s, long l, long l1, int normalValue);
    List<SensorDocRepository> findByPatientIdAndTimestampBetween(String s, long l, long l1);
}
