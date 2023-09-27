package cars.domain.repo;

import cars.domain.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OwnersRepository extends JpaRepository<Owner, Integer> {
    List<Owner> findByBirthYearBetween(int birthYearFrom, int birthYearTo);

//JPQL
//    агрегатные запросы из БД
//    SELECT * FROM owners JOIN cars GROUP BY owners.id
//    1 option
    @Query("SELECT owner FROM Owner owner WHERE size(owner.cars)>=:am")
    List<Owner> getOwnersCarsAmount(@Param(value = "am") int amount);

//    2 option (1 - порядковый номер параметров -  int amount)
//    @Query("SELECT own FROM Owner own WHERE size(own.cars)>=?1")
//    List<Owner> getOwnersCarsAmount(int amount);

    @Query("SELECT o FROM Owner o WHERE birthYear < (SELECT AVG(birthYear) FROM Owner )")
    List<Owner>findOlderOwners();
}
