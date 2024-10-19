package fr.istic.tp342.dao;


import fr.istic.tp342.dto.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionDao extends CrudRepository<Question, Long> {
    public Question findById(long id);
}
