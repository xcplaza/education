package calculator.accounting.controllers;


import calculator.accounting.dto.RolesResponseDTO;
import calculator.accounting.dto.UserAccountResponseDTO;
import calculator.accounting.dto.UserRegisterDTO;
import calculator.accounting.dto.UserUpdateDTO;
import calculator.accounting.service.IAccounting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/account")
@EnableMethodSecurity(prePostEnabled = true) //приоритет над нашими spring security firewall
public class AccountingController {
    @Autowired
    IAccounting service;

    @PostMapping({"/register", "/register/", "/operations"})
    public UserAccountResponseDTO registration(@RequestBody UserRegisterDTO account) {
        return service.registration(account);
    }

    @DeleteMapping("/user/{login}")
    @PreAuthorize("hasRole('ADMIN')") // сначала сделать это, до requestMatchers
    public UserAccountResponseDTO removeUser(@PathVariable String login) {
        return service.removeUser(login);
    }

    @PostMapping("/login")
    public UserAccountResponseDTO loginUser(Principal principal) {
//        String[] credentials = getGredentials(token);
        return service.getUser(principal.getName());
    }

//    private String[] getGredentials(String token) {
//        String[] base = token.split(" "); // split BASIC from - login:password
//        String decode = new String(Base64.getDecoder().decode(base[1])); // decode token
//        return decode.split(":"); // split login:password
//    }

    @PutMapping("/user/{login}")
    public UserAccountResponseDTO editUser(@PathVariable String login, @RequestBody UserUpdateDTO account) {
        return service.editUser(login, account);
    }

    @PutMapping("/password")
    public boolean updatePassword(Principal pr, @RequestHeader("X-New-Password") String password) {
        return service.updatePassword(pr.getName(), password);
    }

//    @PutMapping("/password/{login}")
//    public boolean updatePassword(@PathVariable String login, @RequestHeader("X-New-Password") String password) {
//        return service.updatePassword(login, password);
//    }

    @PutMapping("/revoke/{login}")
    public boolean revokeAccount(@PathVariable String login) {
        return service.revokeAccount(login);
    }

    @PutMapping("/activate/{login}")
    public boolean activateAccount(@PathVariable String login) {
        return service.activateAccount(login);
    }

    @PutMapping("/user/{login}/role/{role}")
    public RolesResponseDTO addRole(@PathVariable String login, @PathVariable String role) {
        return service.addRole(login, role);
    }

    @DeleteMapping("/user/{login}/role/{role}")
    public RolesResponseDTO removeRole(@PathVariable String login, @PathVariable String role) {
        return service.removeRole(login, role);
    }

    @GetMapping("/roles/{login}")
    public RolesResponseDTO getRoles(@PathVariable String login) {
        return service.getRoles(login);
    }

    @GetMapping("/password/{login}")
    public String getPasswordHash(@PathVariable String login) {
        return service.getPasswordHash(login);
    }

    @GetMapping("/activation_date/{login}")
    public LocalDateTime getActivationDate(@PathVariable String login) {
        return service.getActivationDate(login);
    }
}
