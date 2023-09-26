package cars.domain.repo;

import cars.domain.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// связка JAVA объекта с агрегативными запросами из БД
public interface ModelsRepository extends JpaRepository<Model, String> {
    //select modelName, count(*) from models m join cars c ON c.modelName=m.modelName group by = modelName

//  native SQL
//  SELECT * FROM models WHERE modelName in (model name WHERE models WHERE count cars = (MAX FROM = (count cars of each model)))
    @Query(nativeQuery = true, value = "SELECT * FROM models WHERE model_name in (SELECT model_model_name FROM cars GROUP BY model_model_name HAVING count(*)=(SELECT MAX(count() FROM (SELECT count(*) AS count FROM cars GROP BY model_name)))")
    List<Model> getMostPopularModels();
}
