package fr.istic.tp342.controllers;

import fr.istic.tp342.dao.UserDao;
import fr.istic.tp342.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;


    @GetMapping("/user")
    public String getUser(@RequestParam(value = "id", required = false) Long id,
                          @RequestParam(value = "username", required = false) String username) {
        if (id != null) {
            return "Hello " + userDao.findUserById(id).getUsername();
        } else if (username != null) {
            User user = userDao.findUserByUsername(username);
            if (user == null) {
                return "You don't exist!";
            } else {
                return "Hello " + username + ", your id is " + user.getId();
            }
        } else {
            return "Missing parameters!";
        }
    }

    @PostMapping("/user")
    public String postUser(@RequestBody User user){
        User u  = userDao.save(user);
        return "Sauvegardé ! Id = "+u.getId();
    }

    @GetMapping("/user/search")
    public List<User> searchByUsername(@RequestParam String username){
        return userDao.searchByUsername(username);
    }

}
