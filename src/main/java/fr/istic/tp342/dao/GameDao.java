package fr.istic.tp342.dao;

import fr.istic.tp342.dto.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDao extends JpaRepository<Game, Long> {
    public Game findGameById(long id);
}
