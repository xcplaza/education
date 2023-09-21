package cars.domain.repo;

import cars.domain.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnersRepository extends JpaRepository<Owner, Integer> {
}
