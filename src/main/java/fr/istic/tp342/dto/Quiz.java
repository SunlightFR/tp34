package fr.istic.tp342.dto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Quiz  implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private User creator;

    @OneToMany
    private List<Question> questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
