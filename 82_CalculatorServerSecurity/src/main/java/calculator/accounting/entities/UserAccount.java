package calculator.accounting.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "user_accounts")
public class UserAccount {
    @Id
    private String login;
    private String hash;
    private String firstName;
    private String lastName;
    private HashSet<String> roles;
    private LocalDateTime activationDate;
    private boolean revoked;
    private LinkedList<String> lastHashCodes;

    public UserAccount(String login, String hash, String firstName, String lastName) {
        this.login = login;
        this.hash = hash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = new HashSet<>();
        roles.add("USER");
        this.activationDate = LocalDateTime.now();
        this.lastHashCodes = new LinkedList<>();
    }
}
