package calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "CalculatorAPI", version = "1", 
		description = "This is simple double calculator"))
@SpringBootApplication
public class CalculatorServerAppl
{

	public static void main(String[] args)
	{

		SpringApplication.run(CalculatorServerAppl.class, args);
	}

}
