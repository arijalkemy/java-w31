package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class TestCase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCase;

    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;
}
