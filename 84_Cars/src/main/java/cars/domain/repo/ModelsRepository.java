package cars.domain.repo;

import cars.domain.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelsRepository extends JpaRepository<Model, String> {
}
