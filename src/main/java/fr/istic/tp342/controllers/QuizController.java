package fr.istic.tp342.controllers;

import fr.istic.tp342.dao.QuestionDao;
import fr.istic.tp342.dao.QuizDao;
import fr.istic.tp342.dao.UserDao;
import fr.istic.tp342.dto.Question;
import fr.istic.tp342.dto.Quiz;
import fr.istic.tp342.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuizDao quizDao;
    private final QuestionDao questionDao;
    private final UserDao userDao;

    @PostMapping("/quiz")
    public String createQuiz(@RequestBody Quiz quiz){
        Quiz q = quizDao.save(quiz);
        return "Quiz créé avec succès avec l'id "+q.getId();
    }

    // Ajouter une question à un quiz existant
    @PostMapping("/quiz/{quizId}/addQuestion")
    public String addQuestionToQuiz(@PathVariable long quizId, @RequestBody Question question) {
        Quiz quiz = quizDao.findById(quizId);

        if (quiz == null) {
            return "Quiz not found";
        }

        questionDao.save(question);
        quiz.getQuestions().add(question);

        quizDao.save(quiz);

        return "Question added successfully";
    }

    @GetMapping("/quiz/by/{userId}")
    public String getByCreator(@PathVariable long userId){
        User creator = userDao.findUserById(userId);
        List<Quiz> q = quizDao.findByCreator(creator);
        String s = "";
        for(Quiz quiz:q){
            s+="quiz : id : "+quiz.getId()+"\n";
        }
        return s;
    }
}
