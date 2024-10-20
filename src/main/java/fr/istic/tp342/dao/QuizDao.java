package fr.istic.tp342.dao;


import fr.istic.tp342.dto.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface QuizDao extends JpaRepository<Quiz, Long> {
    public Quiz findById(long id);
}
