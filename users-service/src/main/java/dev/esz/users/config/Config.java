package dev.esz.users.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper() {{
            getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }};
        return modelMapper;
    }
}
