package cars.domain.repo;

import cars.domain.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface OwnersRepository extends JpaRepository<Owner, Integer> {
    Owner findByBirthDateBetween(LocalDate from, LocalDate to);
}
