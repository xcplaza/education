package accounting.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)    //409 - error
public class UserExistsExceptions extends RuntimeException {

    public UserExistsExceptions(String login) {
        super("User with login " + login + " is already exists");
    }
}
