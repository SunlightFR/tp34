package fr.istic.tp342.dao;


import fr.istic.tp342.dto.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    public User findUserById(long id);
}
