package cars.domain.repo;

import cars.domain.entities.Car;
import cars.domain.view.ColorCount;
import cars.domain.view.ModelAge;
import cars.domain.view.ModelCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CarsRepository extends JpaRepository<Car, Long> {
    List<Car> findByModelModelName(String modelName);
    List<Car> findByPurchaseDateBetween(LocalDate of, LocalDate line);
    void deleteAllByOwnerId(int ownerId);

    //    JPQL
//    агрегатные запросы из БД
//    SELECT m.modelName, count(*) FROM models m JON cars, c ON c.modelName=m.modelName group by m.modelName
    @Query("SELECT model.modelName AS modelName, COUNT(*) AS count from Car GROUP BY model.modelName")
    List<ModelCount> getModelsCount();

    //  native SQL
    @Query(nativeQuery = true, value = "select model_model_name from cars "
            + "join owners on owner_id=id where birth_year between :fy and "
            + ":ft and purchase_date between :fd and :td group by "
            + "model_model_name having count(*) = "
            + "(select max(count) from "
            + "(select count(*) as count from cars "
            + "join owners on owner_id=id where birth_year between :fy and "
            + ":ft and purchase_date between :fd and :td group by "
            + "model_model_name))")
    List<String> getModelDateAge(@Param("fd") LocalDate fromDate, @Param("td") LocalDate toDate, @Param("fy") int birthYearFrom, @Param("ft") int birthYearTo);

    @Query("SELECT color AS color, COUNT(*) AS count FROM Car GROUP BY color")
    List<ColorCount> getColorCounts();

    @Query("SELECT model.modelName AS modelName, avg(year(current_date) - owner.birthYear) AS age FROM Car GROUP BY model.modelName")
    List<ModelAge> getModelsAvgAge();
}
