package cars.domain.repo;

import cars.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarsRepository extends JpaRepository<Car, Long> {
    List<Car> findByModelModelName(String modelName);
}
