package calculator.accounting.service;

import calculator.accounting.dto.RolesResponseDto;
import calculator.accounting.dto.UserAccountResponseDto;
import calculator.accounting.dto.UserRegisterDto;
import calculator.accounting.dto.UserUpdateDto;
import calculator.accounting.dto.exceptions.UserExistsException;
import calculator.accounting.dto.exceptions.UserNotFoundException;
import calculator.accounting.dto.exceptions.WrongPasswordException;
import calculator.accounting.entities.UserAccount;
import calculator.accounting.repo.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

@Service
public class AccountingMongo implements IAccounting, CommandLineRunner
{
	@Autowired
	UserAccountRepository repository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Value("${password_length:5}")
	private int passwordLength;
	
	@Value("${n_last_hashcodes:3}")
	private int nLastHashcodes;
	
	@Override
	public UserAccountResponseDto registration(UserRegisterDto account)
	{
		String login = account.getLogin();
		if(login == null || repository.existsById(login))
			throw new UserExistsException(login);
		
		String password = account.getPassword();
		if(!isPasswordValid(password))
			throw new WrongPasswordException(password);
		
		UserAccount user = new UserAccount(login, getHashCode(password), 
				account.getFirstName(), account.getLastName());
		repository.save(user);
		return new UserAccountResponseDto(login, account.getFirstName(), 
				account.getLastName(), user.getRoles());
	}

	private String getHashCode(String password)
	{
		return encoder.encode(password);
	}

	private boolean isPasswordValid(String password)
	{
		return password.length() >= passwordLength;
	}

	@Override
	public UserAccountResponseDto removeUser(String login)
	{
		UserAccount account = repository.findById(login)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
				"Account with login " + login + " not found"));
		repository.delete(account);
		return new UserAccountResponseDto(login, account.getFirstName(), 
				account.getLastName(), account.getRoles());

	}

	@Override
	public UserAccountResponseDto getUser(String login)
	{
		UserAccount account = repository.findById(login)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
				"Account with login " + login + " not found"));
		return new UserAccountResponseDto(login, account.getFirstName(), 
				account.getLastName(), account.getRoles());

	}

	@Override
	public UserAccountResponseDto editUser(String login, UserUpdateDto account)
	{
		UserAccount accountMongo = repository.findById(login)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
						"Account with login " + login + " not found"));
		
		if (account.getFirstName() != null)
			accountMongo.setFirstName(account.getFirstName());
		if (account.getLastName() != null)
			accountMongo.setLastName(account.getLastName());
		
		repository.save(accountMongo);
		return new UserAccountResponseDto(login, accountMongo.getFirstName(), 
				accountMongo.getLastName(),	accountMongo.getRoles());

	}

	@Override
	public boolean updatePassword(String login, String password)
	{
		if(!isPasswordValid(password))
			throw new WrongPasswordException(password);
		
		UserAccount user = repository.findById(login)
				.orElseThrow(() -> new UserNotFoundException(login));
		
		if(encoder.matches(password, user.getHash()))
			throw new WrongPasswordException(password);
		
		LinkedList<String> lastHashs = user.getLastHashCodes();
		if(isPasswordFromLast(password, lastHashs))
			throw new WrongPasswordException(password);
		
		if(lastHashs.size() == nLastHashcodes)
			lastHashs.removeFirst();
		lastHashs.add(user.getHash());
		
		user.setHash(encoder.encode(password));
		user.setActivationDate(LocalDateTime.now());
		repository.save(user);
		return true;
	}

	private boolean isPasswordFromLast(String password, LinkedList<String> lastHashs)
	{
		return lastHashs.stream().anyMatch(hash -> encoder.matches(password, hash));
	}

	@Override
	public boolean revokeAccount(String login)
	{
		UserAccount account = repository.findById(login)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
						"Account with login " + login + " not found"));
		if (account.isRevoked())
			throw new ResponseStatusException(HttpStatus.CONFLICT, 
					"Account with login " + login + " already revoked");
		
		account.setRevoked(true);
		repository.save(account);
		return true;
	}

	@Override
	public boolean activateAccount(String login)
	{
		UserAccount account = repository.findById(login)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
				"Account with login " + login + " not found"));
		if (!account.isRevoked())
			throw new ResponseStatusException(HttpStatus.CONFLICT, 
					"Account with login " + login + " already activated");
		
		account.setRevoked(false);
		account.setActivationDate(LocalDateTime.now());
		repository.save(account);
		return true;

	}

	@Override
	public RolesResponseDto addRole(String login, String role)
	{
		UserAccount account = repository.findById(login)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
				"Account with login " + login + " not found"));
		
		HashSet<String> roles = account.getRoles();
		if (roles.contains(role))
			throw new ResponseStatusException(HttpStatus.CONFLICT, 
					"Role " + role + " already exists");
		
		roles.add(role);
		repository.save(account);
		return new RolesResponseDto(login, account.getRoles());

	}

	@Override
	public RolesResponseDto removeRole(String login, String role)
	{
		UserAccount account = repository.findById(login)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
				"Account with login " + login + " not found"));
		
		HashSet<String> roles = account.getRoles();
		if (!roles.contains(role))
			throw new ResponseStatusException(HttpStatus.CONFLICT, 
					"Role " + role + " not exists");
		
		roles.remove(role);
		repository.save(account);
		return new RolesResponseDto(login, account.getRoles());
	}

	@Override
	public RolesResponseDto getRoles(String login)
	{
		UserAccount account = repository.findById(login)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
						"Account with login " + login + " not found"));
		return account.isRevoked() ? null : new RolesResponseDto(login, account.getRoles());

	}

	@Override
	public String getPasswordHash(String login)
	{
		UserAccount account = repository.findById(login)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
				"Account with login " + login + " not found"));
		return account.isRevoked() ? null : account.getHash();

	}

	@Override
	public LocalDateTime getActivationDate(String login)
	{
		UserAccount account = repository.findById(login)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
				"Account with login " + login + " not found"));
		return account.isRevoked() ? null : account.getActivationDate();

	}

	@Override
	public void run(String... args) throws Exception
	{
		if(!repository.existsById("admin"))
		{
			UserAccount user = new UserAccount("admin", encoder.encode("admin"), "", "");
			user.setRoles(new HashSet<>(Arrays.asList("ADMIN")));
			repository.save(user);
		}
	}
}
//USER, ADMIN
