package fr.istic.tp342.dao;


import fr.istic.tp342.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    public User findUserById(long id);
    public User findUserByUsername(String username);
}
