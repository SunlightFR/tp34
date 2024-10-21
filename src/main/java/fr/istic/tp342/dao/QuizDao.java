package fr.istic.tp342.dao;


import fr.istic.tp342.dto.Quiz;
import fr.istic.tp342.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuizDao extends JpaRepository<Quiz, Long> {
    public Quiz findById(long id);
    public List<Quiz> findByCreator(User user);

    @Query("SELECT COUNT (*) FROM Game g WHERE g.quiz.id = :id")
    public long getQuizStatistics(long id);
}
