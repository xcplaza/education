package calculator.accounting.service;

import calculator.accounting.dto.RolesResponseDto;
import calculator.accounting.dto.UserAccountResponseDto;
import calculator.accounting.dto.UserRegisterDto;
import calculator.accounting.dto.UserUpdateDto;

import java.time.LocalDateTime;

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
