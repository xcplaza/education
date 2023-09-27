package telran.cars.accounting.service;

import java.time.LocalDateTime;

import telran.cars.accounting.dto.RolesResponseDto;
import telran.cars.accounting.dto.UserAccountResponseDto;
import telran.cars.accounting.dto.UserRegisterDto;
import telran.cars.accounting.dto.UserUpdateDto;

public interface IAccounting
{
	UserAccountResponseDto registration(UserRegisterDto account);
	UserAccountResponseDto removeUser(String login);
	UserAccountResponseDto getUser(String login);
	UserAccountResponseDto editUser(String login, UserUpdateDto account);
	
	boolean updatePassword(String login, String password);
	boolean revokeAccount(String login);
	boolean activateAccount(String login);
	
	RolesResponseDto addRole(String login, String role);
	RolesResponseDto removeRole(String login, String role);
	RolesResponseDto getRoles(String login);
	
	String getPasswordHash(String login);
	LocalDateTime getActivationDate(String login);
}
