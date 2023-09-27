package telran.cars.accounting.controllers;

import java.security.Principal;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import telran.cars.accounting.dto.RolesResponseDto;
import telran.cars.accounting.dto.UserAccountResponseDto;
import telran.cars.accounting.dto.UserRegisterDto;
import telran.cars.accounting.dto.UserUpdateDto;
import telran.cars.accounting.service.IAccounting;


@RestController
@RequestMapping("/account")
@EnableMethodSecurity(prePostEnabled = true)
public class AccountingController
{
	@Autowired
	IAccounting service;

	@PostMapping({"/register", "/register/"})
	public UserAccountResponseDto registration(@RequestBody UserRegisterDto account)
	{
		return service.registration(account);
	}
	
	@DeleteMapping("/user/{login}")
	@PreAuthorize("hasRole('ADMIN')")
	public UserAccountResponseDto removeUser(@PathVariable String login)
	{
		return service.removeUser(login);
	}

	@PostMapping("/login")
	public UserAccountResponseDto login(Principal principal)
	{
		return service.getUser(principal.getName());
	}

	@PutMapping("/user/{login}")
	public UserAccountResponseDto editUser(@PathVariable String login, 
			@RequestBody UserUpdateDto account)
	{
		return service.editUser(login, account);
	}

	@PutMapping("/password")
	public boolean updatePassword(Principal pr, 
			@RequestHeader("X-New-Password") String password)
	{
		return service.updatePassword(pr.getName(), password);
	}

	@PutMapping("/revoke/{login}")
	public boolean revokeAccount(@PathVariable String login)
	{
		return service.revokeAccount(login);
	}

	@PutMapping("/activate/{login}")
	public boolean activateAccount(@PathVariable String login)
	{
		return service.activateAccount(login);
	}

	@PutMapping("/user/{login}/role/{role}")
	public RolesResponseDto addRole(@PathVariable String login, @PathVariable String role)
	{
		return service.addRole(login, role);
	}

	@DeleteMapping("/user/{login}/role/{role}")
	public RolesResponseDto removeRole(@PathVariable String login, @PathVariable String role)
	{
		return service.removeRole(login, role);
	}

	@GetMapping("/roles/{login}")
	public RolesResponseDto getRoles(@PathVariable String login)
	{
		return service.getRoles(login);
	}

	@GetMapping("/password/{login}")
	public String getPasswordHash(@PathVariable String login)
	{
		return service.getPasswordHash(login);
	}

	@GetMapping("/activation_date/{login}")
	public LocalDateTime getActivationDate(@PathVariable String login)
	{
		return service.getActivationDate(login);
	}
}
