package fr.istic.tp342.dto;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class MultipleChoiceQuestion extends Question{
    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    List<String> answers;
}
