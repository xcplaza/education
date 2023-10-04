package office.repo;

import office.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDateTime;
import java.util.List;

@EnableMongoRepositories
public interface Repos extends MongoRepository<Patient, Integer> {
    List<Integer> findBySensorIdAndAvgValueGreaterThanAndTimestampBetween(
            int sensorId, int normalValue, LocalDateTime from, LocalDateTime to);

    List<Integer> findBySensorIdAndAvgValueLessThanAndTimestampBetween(
            int sensorId, int normalValue, LocalDateTime from, LocalDateTime to);

    @Query(value = "{ 'sensorId': ?0, 'avgValue': { '$gt': ?1, '$lt': ?2 }, 'timestamp': { '$gte': ?3, '$lte': ?4 } }", fields = "{ 'timestamp': 1 }")
    List<LocalDateTime> getDatesBySensorIdAndAvgValueRange(int sensorId, int normalValue, LocalDateTime from, LocalDateTime to);
}
