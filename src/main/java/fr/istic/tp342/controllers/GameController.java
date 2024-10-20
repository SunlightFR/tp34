package fr.istic.tp342.controllers;

import fr.istic.tp342.dao.GameDao;
import fr.istic.tp342.dto.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GameController {
    private final GameDao gameDao;

    @GetMapping("/game/{id}")
    public String doGet(@PathVariable long id){
        Game game = gameDao.findGameById(id);
        return game.toString();
    }
}
