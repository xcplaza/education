package calculator.accounting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserAccountResponseDTO {
    private String login;
    private String firstName;
    private String lastName;
    private Set<String> roles;

}
