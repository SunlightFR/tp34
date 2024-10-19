package fr.istic.tp342.dto;

import jakarta.persistence.Entity;

@Entity
public class SingleChoiceQuestion extends Question{
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    String answer;
}
