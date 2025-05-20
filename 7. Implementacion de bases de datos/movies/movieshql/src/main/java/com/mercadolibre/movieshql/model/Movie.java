package com.mercadolibre.movieshql.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
@Data
public class Movie {
    @Id
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String title;
    private BigDecimal rating;
    private Integer awards;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    private Integer length;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @JsonBackReference
    @ManyToMany(mappedBy = "movies")
    private Set<Actor> actors = new HashSet<>();
}
