package com.mercadolibre.hql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    Double rating;
    @ManyToOne
    @JoinColumn(name = "favorite_movie_id", nullable = false)
    private Movie movie;
    @OneToMany(mappedBy = "actor")
    private Set<ActorEpisode> actorsEpisodes;
    @OneToMany(mappedBy = "actor")
    private Set<ActorMovie> actorMovies;
}
