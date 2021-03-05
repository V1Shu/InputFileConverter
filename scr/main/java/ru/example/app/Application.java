package ru.example.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.example.app.model.FileData;
import ru.example.app.services.ConvertServiceImpl;

@Configuration
@ComponentScan("ru.example.app.services")
public class Application {

    public static void main(String[] args) {
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);

        String[] fileList = new String[] {"order1.csv", "order3.json"};

        ConvertServiceImpl convertService = new ConvertServiceImpl();

        for (FileData fileData : convertService.convertFile(args)) {
            System.out.println(fileData);
        }
    }
}
