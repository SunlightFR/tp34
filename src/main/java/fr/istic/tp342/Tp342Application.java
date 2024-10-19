package fr.istic.tp342;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"fr.istic.*"})
@EntityScan("fr.istic.dto")
@EnableJpaRepositories("fr.istic.dao")
public class Tp342Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp342Application.class, args);
    }

}
