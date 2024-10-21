package fr.istic.tp342.controllers;

import fr.istic.tp342.dao.GameDao;
import fr.istic.tp342.dao.UserDao;
import fr.istic.tp342.dto.Game;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GameController {
    private final GameDao gameDao;
    private final UserDao userDao;

    @GetMapping("/game/{id}")
    public String doGet(@PathVariable long id){
        Game game = gameDao.findGameById(id);
        return game.toString();
    }

    @PostMapping("/game")
    public String doPost(@RequestBody Game game){
        Game g = gameDao.save(game);
        return "Jeu créé avec succès avec l'id "+g.getId();
    }

    @PutMapping("/game/join")
    public ResponseEntity<String> joinGame(@PathParam("gameId") long gameId, @PathParam("userId") long userId){
        Game game = gameDao.findGameById(gameId);
        if(game != null){
            if(userDao.existsById(userId)){
                game.getPlayers().add(userDao.findUserById(userId));
                return new ResponseEntity<>("L'utilisateur a bien rejoint le jeu !", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Cet utilisateur n'existe pas.", HttpStatus.NOT_FOUND);
            }
        }
        else{
            return new ResponseEntity<>("Ce jeu n'existe pas", HttpStatus.NOT_FOUND);
        }
    }
}
