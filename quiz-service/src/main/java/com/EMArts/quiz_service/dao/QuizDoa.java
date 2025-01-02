package com.EMArts.quiz_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EMArts.quiz_service.model.Quiz;


@Repository
public interface QuizDoa extends JpaRepository<Quiz, Integer> {
    
}
