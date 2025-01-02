package com.EMArts.question_service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.EMArts.question_service.model.Question;

@Repository
//  @Profile("dev")  // Example of instantiating a Bean only if the defined Spring profile is selected. Default is @Profile("default") 
public interface QuestionDao extends JpaRepository<Question, Integer> {  // <Table name, Primary key>

    List<Question> findByCategory(String category);  // Capable of finding database data thanks to JPA and Hibernate

    @Query(value = "SELECT q.id FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQuestions", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQuestions") int numQuestions);
} 
