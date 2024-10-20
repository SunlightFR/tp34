package fr.istic.tp342.dao;


import fr.istic.tp342.dto.Quiz;
import fr.istic.tp342.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuizDao extends JpaRepository<Quiz, Long> {
    public Quiz findById(long id);
    public List<Quiz> findByCreator(User user);
}
