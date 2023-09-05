package calculator.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorConfiguration {

    @Bean
    public ICalculator getCalculator(){
        return new CalculatorMap();
    }
}
