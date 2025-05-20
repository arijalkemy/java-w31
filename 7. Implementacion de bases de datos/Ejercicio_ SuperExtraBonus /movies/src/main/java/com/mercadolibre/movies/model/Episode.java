package com.mercadolibre.movies.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "episodes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Column(length = 500)
    private String title;

    private Integer number;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @Column(precision = 3, scale = 1)
    private BigDecimal rating;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "id")
    private Season season;
}
