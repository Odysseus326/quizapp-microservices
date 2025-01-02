package com.EMArts.quiz_service.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data  // Imports getters / setters / toString methods
@Entity
@Table(name="quiz")
public class Quiz {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @ElementCollection  // @ManyToMany does not work for numbers, @ElementCollection is used instead
    @Column(name = "questions", nullable = false)
    private List<Integer> questionIds;
}
