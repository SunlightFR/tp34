package fr.istic.tp342.dao;


import fr.istic.tp342.dto.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends CrudRepository<Quiz, Long> {
    public Quiz findById(long id);
}
