package accounting.security;

import accounting.entities.UserAccount;
import accounting.repo.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomWebSecurity {

    @Autowired
    UserAccountRepository repository;

    public boolean checkOwner(String login) {
        UserAccount user = repository.findById(login).orElse(null);
        return user != null;
    }
}
