package calculator;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "CalculatorAPI", version = "1", description = "My first calculator"))
@SpringBootApplication
public class CalculatorServerAppl
{

	public static void main(String[] args)
	{
		SpringApplication.run(CalculatorServerAppl.class, args);
	}

}
