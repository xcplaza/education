package office.repos;
import office.entity.SensorDocRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.*;
import java.util.List;

public interface Repos extends MongoRepository<SensorDocRepository, String> {

    List<SensorDocRepository> findByTimestampBetweenAndAvgValueGreaterThanEqual(long l, long l1, int normalValue);

    List<SensorDocRepository> findByTimestampBetweenAndAvgValueLessThan(long l, long l1, int normalValue);

    List<SensorDocRepository> findByPatientIdAndTimestampBetweenAndAvgValueGreaterThanEqual(String s, long l, long l1, int normalValue);

    List<SensorDocRepository> findByPatientIdAndTimestampBetweenAndAvgValueLessThan(String s, long l, long l1, int normalValue);
}
