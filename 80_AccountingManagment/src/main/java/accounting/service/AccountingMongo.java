package accounting.service;

import accounting.dto.RolesResponseDTO;
import accounting.dto.UserAccountResponseDTO;
import accounting.dto.UserRegisterDTO;
import accounting.dto.UserUpdateDTO;
import accounting.dto.exceptions.UserExistsExceptions;
import accounting.dto.exceptions.UserNotFoundExeption;
import accounting.dto.exceptions.WrongPasswordException;
import accounting.entities.UserAccount;
import accounting.repo.UserAccountRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@Service
public class AccountingMongo implements IAccounting, CommandLineRunner {
    @Autowired
    UserAccountRepository repository;

    @Value("${password_leght:5}")
    private int passwordLenght;

    @Value("${n_last_hashcodes:3}")
    private int nLastHashCodes;

    @Override
    public UserAccountResponseDTO registration(UserRegisterDTO account) {
        String login = account.getLogin();
        if (login == null || repository.existsById(login))
            throw new UserExistsExceptions(login);

        String password = account.getPassword();
        if (!isPasswordValid(password))
            throw new WrongPasswordException(password);

        UserAccount user = new UserAccount(login, getHashCode(password), account.getFirstName(), account.getLastName());
        repository.save(user);
        return new UserAccountResponseDTO(account.getLogin(), account.getFirstName(), account.getFirstName(), user.getRoles());
    }

    private String getHashCode(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= passwordLenght;
    }

    @Override
    public UserAccountResponseDTO removeUser(String login) {
        UserAccount user = repository.findById(login).orElseThrow(() -> new UserNotFoundExeption(login));
        repository.delete(user);
        return new UserAccountResponseDTO(login, user.getFirstName(), user.getLastName(), user.getRoles());
    }

    @Override
    public UserAccountResponseDTO getUser(String login) {
        UserAccount user = repository.findById(login).orElseThrow(() -> new UserNotFoundExeption(login));
        return new UserAccountResponseDTO(user.getLogin(), user.getFirstName(), user.getLastName(), user.getRoles());
    }

    @Override
    public UserAccountResponseDTO editUser(String login, UserUpdateDTO account) {
        UserAccount user = repository.findById(login).orElseThrow(() -> new UserNotFoundExeption(login));
        if (user.getFirstName() != null)
            user.setFirstName(user.getFirstName());
        if (user.getLastName() != null)
            user.setLastName(user.getLastName());
        repository.save(user);
        return new UserAccountResponseDTO(login, user.getFirstName(), user.getLastName(), user.getRoles());
    }

    @Override
    public boolean updatePassword(String login, String password) {
        if (!isPasswordValid(password))
            throw new WrongPasswordException(password);

        UserAccount user = repository.findById(login).orElseThrow(() -> new UserNotFoundExeption(login));

        if (BCrypt.checkpw(password, user.getHash()))
            throw new WrongPasswordException(password);

        LinkedList<String> lastHashs = user.getLastHashCodes();

        if (isPasswordFromLast(password, lastHashs))
            throw new WrongPasswordException(password);

        if (lastHashs.size() == nLastHashCodes)
            lastHashs.removeFirst();
        lastHashs.add(user.getHash());

        user.setHash(BCrypt.hashpw(password, BCrypt.gensalt()));
        user.setActivationDate(LocalDateTime.now());
        repository.save(user);
        return true;
    }

    private boolean isPasswordFromLast(String password, LinkedList<String> lastHashs) {
        return lastHashs.stream().anyMatch(hash -> BCrypt.checkpw(password, hash));
    }

    @Override
    public boolean revokeAccount(String login) {
        UserAccount user = repository.findById(login).orElseThrow(() -> new UserNotFoundExeption(login));
        if (user.isRevoked() == true)
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Account " + login + " is revoked");
        user.setRevoked(true);
        repository.save(user);
        return true;
    }


    @Override
    public boolean activateAccount(String login) {
        UserAccount user = repository.findById(login).orElseThrow(() -> new UserNotFoundExeption(login));
        if (!user.isRevoked())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Account " + login + " already revoked");
        user.setRevoked(false);
        user.setActivationDate(LocalDateTime.now());
        repository.save(user);
        return true;
    }

    @Override
    public RolesResponseDTO addRole(String login, String role) {
        //USER, ADMIN
        UserAccount user = repository.findById(login).orElseThrow(() -> new UserNotFoundExeption(login));

        HashSet<String> roles = user.getRoles();
        if (roles.contains(role))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Role " + role + " already exists");
        roles.add(role);
        repository.save(user);
        return new RolesResponseDTO(login, user.getRoles());
    }

    @Override
    public RolesResponseDTO removeRole(String login, String role) {
        UserAccount user = repository.findById(login).orElseThrow(() -> new UserNotFoundExeption(login));
        HashSet<String> roles = user.getRoles();
        if (!roles.contains(role))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Role " + role + " not exists");
        roles.remove(role);
        repository.save(user);
        return new RolesResponseDTO(login, user.getRoles());
    }

    @Override
    public RolesResponseDTO getRoles(String login) {
        UserAccount user = repository.findById(login).orElseThrow(() -> new UserNotFoundExeption(login));
        HashSet<String> roles = user.getRoles();
        return user.isRevoked() ? null : new RolesResponseDTO(login, user.getRoles());
    }

    @Override
    public String getPasswordHash(String login) {
        return repository.findById(login).get().getHash();
    }

    @Override
    public LocalDateTime getActivationDate(String login) {
        return repository.findById(login).get().getActivationDate();
    }

    @Override
    public void run(final String... args) throws Exception {
        if (!repository.existsById("admin")) {
            UserAccount user = new UserAccount("admin", BCrypt.hashpw("admin", BCrypt.gensalt()), "", "");
            user.setRoles(new HashSet<>(Arrays.asList("ADMIN")));
            repository.save(user);
        }
    }
}
