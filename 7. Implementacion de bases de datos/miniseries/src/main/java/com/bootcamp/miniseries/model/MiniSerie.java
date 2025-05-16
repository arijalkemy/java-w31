package com.bootcamp.miniseries.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "miniserie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal rating;

    private Integer amountOfAwards;
}
