package calculator.accounting.repo;

import calculator.accounting.entities.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserAccountRepository extends MongoRepository<UserAccount, String>{

}
