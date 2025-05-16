package com.mercadolibre.testcases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "test_case")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer numberOfTries;
    private LocalDate lastUpdate;

    public TestCase(String description, Boolean tested, Boolean passed, Integer numberOfTries, LocalDate lastUpdate) {
        this.description = description;
        this.tested = tested;
        this.passed = passed;
        this.numberOfTries = numberOfTries;
        this.lastUpdate = lastUpdate;
    }

    @PrePersist
    protected void onCreate() {
        lastUpdate = LocalDate.now();
    }
}
