package telran.cars.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import telran.cars.model.IRentCompany;
import telran.cars.model.RentCompanyEmbedded;

@Configuration
public class RentCompanyConfiguration {

    @Value("${fileName:company.data}")
    private String fileName;

    @Bean
    IRentCompany getRentCompany(){
        return RentCompanyEmbedded.restoreFromFile(fileName);
    }


}
