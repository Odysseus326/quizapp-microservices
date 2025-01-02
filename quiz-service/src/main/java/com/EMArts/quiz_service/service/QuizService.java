package com.EMArts.quiz_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.EMArts.quiz_service.dao.QuizDoa;
import com.EMArts.quiz_service.feign.QuizInterface;
import com.EMArts.quiz_service.model.QuestionWrapper;
import com.EMArts.quiz_service.model.Quiz;
import com.EMArts.quiz_service.model.Response;

@Service
public class QuizService {

    @Autowired
    QuizDoa quizDoa;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQuestions, String title) {  // numQ = number of questions
    
        List<Integer> questions = quizInterface.getQuestionForQuiz(category, numQuestions).getBody();  // .getBody() returns just the body of a response entity object
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDoa.save(quiz);
        return new ResponseEntity<>("Quiz successfully created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz = quizDoa.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);

        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);

        return score;
    }
}