package repo;

import entities.ListProbeValues;
import org.springframework.data.repository.CrudRepository;

public interface ListProbeRepo extends CrudRepository<ListProbeValues, Long> {

}
