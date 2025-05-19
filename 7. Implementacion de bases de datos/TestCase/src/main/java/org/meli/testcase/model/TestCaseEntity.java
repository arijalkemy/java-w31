package org.meli.testcase.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class TestCaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idCase;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Boolean tested;
    @Column(nullable = false)
    private Boolean passed;
    @Column(nullable = false)
    private Integer numberOfTries;
    @Column(nullable = false)
    private LocalDate lastUpdate;
}
