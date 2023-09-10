package person.repository;

import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.Repository;
import person.dto.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface PersonRepository extends MongoRepository<Person, Integer> {
    //    READ
    List<Person> findByAddressCity(String string);

    List<Person> findByAddressCityIgnoreCaseAndBirthDateBetween(String city, LocalDate localDate, LocalDate now);

    List<Person> findByAddressCityIn(String[] strings);

    List<Person> findByNameLikeOrIdGreaterThan(String number, int i);

    List<Person> findByNameLikeOrderByIdDesc(String number);

    @Query("{'salary': {'$gte':?0, '$lte':?1}}")
    List<Person> findBySalaryBetween(int i, int i1);

    @Query("{'_class':{'$regex':?0}}")
    List<Person> getByType(String type);

    @CountQuery("{'_class':{'$regex':?0}}")
    Long countPersonByType(String type);

    //        DELETE
//    List<Person> deleteByIdGreaterThan(int i);
    Long deleteByIdGreaterThan(int i);

    @DeleteQuery("{'salary':{'$gte':?0}}")
    List<Person> deleteBySalary(int i);

    Stream<Person> findAllBy();

    //    UPDATE
    @Query("{'_class':{'$regex':?0}}")
    @Update("{'$inc':{'salary': ?1}}")
    void incrementSalary(String type, int salary);

    @Aggregation("{'$group':{_id:null, avgSalary:{'$avg':$salary}}}")
    double getAvgSalary();

    @Aggregation(pipeline = {"{$match: {name: {$regex: ?0}}}", "{$sort: {birthDate: -1}}", "{$limit: ?1}"})
    List<Person> getPersonByNameSortingName(String str, int limit);

    @Aggregation(pipeline = {"{$match: {name: {$regex: ?0}}}", "{$sort: {birthDate: 1}}", "{$limit: ?1}", "{$project:{name: 1}}"})
    List<String> getNamesByNameSortingName(String str, int limit);
}
