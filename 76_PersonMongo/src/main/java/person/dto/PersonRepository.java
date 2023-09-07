package person.dto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, Integer> {
    List<Person> findByAddressCity(String string);
    List<Person> findByAddressCityAndBirthDateBetween(String rehovot, LocalDate localDate, LocalDate now);
    List<Person> findByAddressCityIn(String[] strings);
}
