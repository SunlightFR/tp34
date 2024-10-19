package fr.istic.tp342.dao;

import fr.istic.tp342.dto.User;
import org.springframework.data.repository.CrudRepository;

public interface GameDao extends CrudRepository<User, Long> {
    public User findUserById(long id);
}
