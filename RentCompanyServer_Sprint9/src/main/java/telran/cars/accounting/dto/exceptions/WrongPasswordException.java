package telran.cars.accounting.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.CONFLICT)//409
public class WrongPasswordException extends RuntimeException
{
	public WrongPasswordException(String password)
	{
		super("Password " + password + " is not valid");
	}
}
