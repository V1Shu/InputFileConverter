package ru.example.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.example.app.configuration.ApplicationConfiguration;
import ru.example.app.model.FileData;
import ru.example.app.services.ConvertService;

@Configuration
@ComponentScan("ru.example.app.services")
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        for (FileData fileData : applicationContext.getBean("converter", ConvertService.class).convertFile(args)) {
            System.out.println(fileData);
        }
    }
}
