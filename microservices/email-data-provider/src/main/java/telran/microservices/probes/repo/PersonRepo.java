package telran.microservices.probes.repo;

import java.util.List;

import entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PersonRepo extends JpaRepository<Person, Long>{
	@Query(value = "select * from persons where sensor_id=:id", nativeQuery = true)
	List<Person> findBySensorId(long id);
}
