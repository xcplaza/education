package person.dto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, Integer> {
    List<Person> findByAddressCity(String string);
    List<Person> findByAddressCityIgnoreCaseAndBirthDateBetween(String rehovot, LocalDate localDate, LocalDate now);
    List<Person> findByAddressCityIn(String[] strings);
    List<Person> findByNameLikeOrIdGreaterThan(String number, int i);
    List<Person> findByNameLikeOrderByIdDesc(String number);
    List<Person> findBySalaryBetween(int i, int i1);
}
