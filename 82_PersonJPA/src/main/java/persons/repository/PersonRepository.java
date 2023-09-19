package persons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persons.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
