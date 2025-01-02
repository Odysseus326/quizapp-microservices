package com.EMArts.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.EMArts.quiz_service.model.QuestionWrapper;
import com.EMArts.quiz_service.model.Response;

@FeignClient("QUESTION-SERVICE")  // Marks this interface for FeignClient, making is usable without specific addresses. Implements load balancing
public interface QuizInterface {

    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category, @RequestParam Integer numQuestions);

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}