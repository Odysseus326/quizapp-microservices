package com.EMArts.question_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data  // Imports getters / setters / toString methods
@Entity
@Table(name="question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_title", nullable = false)
    private String questionTitle;

    @Column(name = "option_1", nullable = false)
    private String option1;

    @Column(name = "option_2", nullable = false)
    private String option2;

    @Column(name = "option_3", nullable = true)
    private String option3;

    @Column(name = "option_4", nullable = true)
    private String option4;

    @Column(name = "right_answer", nullable = false)
    private String rightAnswer;

    @Column(name = "difficulty_level", nullable = false)
    private String difficultyLevel;

    @Column(name = "category", nullable = false)
    private String category;
}
