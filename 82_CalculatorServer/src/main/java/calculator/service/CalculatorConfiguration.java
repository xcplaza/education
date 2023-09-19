package calculator.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CalculatorConfiguration
{
	@Bean("service2")
	@Primary
	public ICalculator getCalculator()
	{
		return new CalculatorMap();
	}
}
