package sensor.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorRepository extends MongoRepository<SensorDoc, Object> {

}