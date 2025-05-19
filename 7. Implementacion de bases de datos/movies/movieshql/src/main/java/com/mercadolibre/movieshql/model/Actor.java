package com.mercadolibre.movieshql.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actors")
@Data
public class Actor {
    @Id
    private Integer id;

    private String firstName;
    private String lastName;
    private BigDecimal rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "favorite_movie_id")
    @JsonIgnore
    private Movie favoriteMovie;

    @ManyToMany(mappedBy = "actors",
            fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Movie> movies = new HashSet<>();

    @ManyToMany(mappedBy = "actors",
            fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Episode> episodes = new HashSet<>();
}

