package ru.example.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.example.app.services.ConvertService;
import ru.example.app.services.ConvertServiceImpl;

/**
 * Configuration file for spring
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    public ConvertService converter() {
        return new ConvertServiceImpl();
    }
}
