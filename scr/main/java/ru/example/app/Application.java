package ru.example.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.example.app.configuration.ApplicationConfigureation;
import ru.example.app.model.FileData;
import ru.example.app.services.ConvertService;
import ru.example.app.services.ConvertServiceImpl;

@Configuration
@ComponentScan("ru.example.app.services")
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfigureation.class);

        String[] fileList = new String[] {"order1.csv", "order3.json"};

        for (FileData fileData : applicationContext.getBean("converter", ConvertService.class).convertFile(fileList)) {
            System.out.println(fileData);
        }
    }
}
