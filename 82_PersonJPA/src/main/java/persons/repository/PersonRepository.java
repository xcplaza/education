package persons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persons.entities.Person;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByAddressCity(String city);

    List<Person> findByBirthDateBetween(LocalDate from, LocalDate to);
}
