package calculator.accounting.service;

import calculator.accounting.dto.RolesResponseDTO;
import calculator.accounting.dto.UserAccountResponseDTO;
import calculator.accounting.dto.UserRegisterDTO;
import calculator.accounting.dto.UserUpdateDTO;

import java.time.LocalDateTime;

public interface IAccounting {
//    USER
    UserAccountResponseDTO registration(UserRegisterDTO account);
    UserAccountResponseDTO removeUser(String login);
    UserAccountResponseDTO getUser(String login);
    UserAccountResponseDTO editUser(String login, UserUpdateDTO account);
    boolean updatePassword(String login, String password);
    boolean revokeAccount(String login);
    boolean activateAccount(String login);
//    ROLES
    RolesResponseDTO addRole(String login, String role);
    RolesResponseDTO removeRole(String login, String role);
    RolesResponseDTO getRoles(String login);

    String getPasswordHash(String login);
    LocalDateTime getActivationDate(String login);
}
