package com.mercadolibre.testcase.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table (name = "test_cases")
public class TestCase {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    @Column (name = "number_of_tries")
    private int numberOfTries;
    @Column (name = "last_update")
    private LocalDate lastUpdate;
}
