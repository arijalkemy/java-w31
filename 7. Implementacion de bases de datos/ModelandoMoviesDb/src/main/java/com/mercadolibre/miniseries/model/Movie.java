package com.mercadolibre.miniseries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.datetime.standard.DateTimeContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Timestamp crearedAt;
    private Timestamp updatedAt;
    private String title;
    private Double rating;
    private Integer awards;
    private Date releaseDate;
    private Integer length;

    @OneToMany
    private Set<Actor> actors;

    @OneToMany
    private Set<ActorMovie> actorMovies;

    @ManyToOne
    @JoinColumn(name = "genreId",nullable = false)
    private Genre genre;

}
