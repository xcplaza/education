package accounting.security;

import accounting.entities.UserAccount;
import accounting.repo.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Configuration
public class Authenticator implements UserDetailsService {
    @Autowired
    UserAccountRepository repository;

    @Value("${activation_period}:3000")
    int activationPeriod;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserAccount user = repository.findById(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        String password = user.getHash();
        String[] roles = user.getRoles().stream().map(r -> "ROLE_" + r).toArray(String[]::new);

        boolean passwordIsNotExpired = ChronoUnit.MINUTES.between(user.getActivationDate(), LocalDateTime.now()) < activationPeriod;
        return new UserProfile(username, password, AuthorityUtils.createAuthorityList(roles), passwordIsNotExpired);
    }
}
