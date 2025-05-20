package com.bootcamp.movies_ejbonus.model;

import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
@Table(name = "actor_episode")
public class ActorEpisode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "episode_id")
    private Episode episode;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}

