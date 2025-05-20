package com.mercadolibre.miniseries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter

public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String firstName;
    private String lastName;
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "favoriteMovieId",nullable = false)
    private Movie movie;

    @OneToMany
    private Set<ActorMovie> actorMovies;

    @OneToMany
    private Set<ActorEpisode> actorEpisodes;

}
