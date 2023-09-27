package cars.configurations;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    @Bean
    ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PACKAGE_PRIVATE).setFieldMatchingEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return mapper;
    }
}
