package com.mercadolibre.qatesters.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCase;

    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;
}
