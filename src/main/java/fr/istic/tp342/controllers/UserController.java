package fr.istic.tp342.controllers;

import fr.istic.tp342.dao.UserDao;
import fr.istic.tp342.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;

    @GetMapping("/user")
    public ResponseEntity<String> getUser(@RequestParam(value = "id", required = false) Long id,
                                         @RequestParam(value = "username", required = false) String username) {
        if (id != null) {
            User user = userDao.findUserById(id);
            if (user == null) {
                return new ResponseEntity<>("Aucun utilisateur avec cet id n'a été trouvé", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>("Bonjour, ton nom est " + user.getUsername(), HttpStatus.OK);
            }
        } else if (username != null) {
            User user = userDao.findUserByUsername(username);
            if (user == null) {
                return new ResponseEntity<>("Aucun utilisateur avec ce nom n'a été trouvé", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>("Bonjour " + username + ", ton id est " + user.getId(), HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("Il manque des paramètres !", HttpStatus.BAD_REQUEST);
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
