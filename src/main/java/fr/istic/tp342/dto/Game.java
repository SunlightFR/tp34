package fr.istic.tp342.dto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Game implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Quiz quiz;

    @ManyToMany
    private List<User> players;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<User> getPlayers() {
        return players;
    }

    public void setPlayers(List<User> players) {
        this.players = players;
    }
}
