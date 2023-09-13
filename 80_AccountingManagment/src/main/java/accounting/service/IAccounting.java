package accounting.service;

import accounting.dto.RolesResponseDTO;
import accounting.dto.UserAccountResponseDTO;
import accounting.dto.UserRegisterDTO;
import accounting.dto.UserUpdateDTO;

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
