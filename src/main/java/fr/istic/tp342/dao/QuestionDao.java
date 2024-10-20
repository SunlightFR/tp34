package fr.istic.tp342.dao;


import fr.istic.tp342.dto.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface QuestionDao extends JpaRepository<Question, Long> {
    public Question findById(long id);
}
