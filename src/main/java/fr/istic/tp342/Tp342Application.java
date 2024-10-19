package fr.istic.tp342;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Tp342Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp342Application.class, args);
    }

}