package com.mercadolibre.movies.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "seasons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Season {

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

    @Column(nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "season")
    List<Episode> episodes;

    @ManyToOne
    @JoinColumn(name = "serie_id", referencedColumnName = "id")
    private Serie serie;




}
