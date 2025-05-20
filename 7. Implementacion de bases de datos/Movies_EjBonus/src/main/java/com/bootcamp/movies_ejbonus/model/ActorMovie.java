package com.bootcamp.movies_ejbonus.model;

import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
@Table(name = "actor_movie")
public class ActorMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;


    private Timestamp createdAt;
    private Timestamp updatedAt;
}

