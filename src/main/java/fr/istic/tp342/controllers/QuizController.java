package fr.istic.tp342.controllers;

import fr.istic.tp342.dao.GameDao;
import fr.istic.tp342.dao.QuestionDao;
import fr.istic.tp342.dao.QuizDao;
import fr.istic.tp342.dao.UserDao;
import fr.istic.tp342.dto.Question;
import fr.istic.tp342.dto.Quiz;
import fr.istic.tp342.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuizDao quizDao;
    private final QuestionDao questionDao;
    private final UserDao userDao;
    private final GameDao gameDao;

    @PostMapping("/quiz")
    public String createQuiz(@RequestBody Quiz quiz){
        Quiz q = quizDao.save(quiz);
        return "Quiz créé avec succès avec l'id "+q.getId();
    }

    // Ajouter une question à un quiz existant
    @PostMapping("/quiz/{quizId}/addQuestion")
    public ResponseEntity<String> addQuestionToQuiz(@PathVariable long quizId, @RequestBody Question question) {
        Quiz quiz = quizDao.findById(quizId);

        if (quiz == null) {
            return new ResponseEntity<>("Aucun quiz avec cet id n'a été trouvé", HttpStatus.NOT_FOUND);
        }

        Question q = questionDao.save(question);
        quiz.getQuestions().add(q);

        quizDao.save(quiz);

        return new ResponseEntity<>("Question ajoutée avec succès avec l'id "+q.getId(), HttpStatus.OK);
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

    @GetMapping("/quiz/stats/{quizId}")
    public ResponseEntity<String> getQuizStats(@PathVariable long quizId){
        long stats = quizDao.getQuizStatistics(quizId);
        return new ResponseEntity<>("Ce jeu a été joué "+stats+" fois", HttpStatus.OK);

    }

    @GetMapping("/quiz/{quizId}")
    public Quiz getById(@PathVariable long quizId){
        return quizDao.findById(quizId);
    }
}
