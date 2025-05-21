package com.mercadolibre.hql.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "favorite_movie_id", nullable = false)
    @JsonBackReference("favorite-movie")
    private Movie movie;
    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<ActorEpisode> actorsEpisodes;
    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<ActorMovie> actorMovies;
}
