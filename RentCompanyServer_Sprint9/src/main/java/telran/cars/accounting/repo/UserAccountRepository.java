package telran.cars.accounting.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.cars.accounting.entities.UserAccount;

public interface UserAccountRepository extends MongoRepository<UserAccount, String>
{

}
