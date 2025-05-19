package com.mercadolibre.testersqa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Entity
@Table
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idCase;
    String description;
    Boolean tested;
    Boolean passed;
    Integer numberOfTries;
    LocalDate lastUpdates;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classToTestId")
    ClassToTest classToTest;
}
