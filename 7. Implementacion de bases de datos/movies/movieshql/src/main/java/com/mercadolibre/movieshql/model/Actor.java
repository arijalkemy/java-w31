package com.mercadolibre.movieshql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    private Movie favoriteMovie;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    @JsonIgnore
    private Set<Movie> movies = new HashSet<>();

    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    private Set<Episode> episodes = new HashSet<>();
}

