package com.mercadolibre.hql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    String title;
    Double rating;
    Integer awards;
    @Column(name = "release_date")
    LocalDateTime releaseDate;
    Integer length;
    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;
    @OneToMany(mappedBy = "movie")
    private Set<Actor> actors;
    @OneToMany(mappedBy = "movie")
    private Set<ActorMovie> actorMovies;
}
