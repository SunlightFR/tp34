package fr.istic.tp342.controllers;

import fr.istic.tp342.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequiredArgsConstructor
public class TestController {


//    private final UserDao userDao;


    // Route qui répond à une requête GET sur /hello
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }

}
