package com.mercadolibre.miniseries.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "Actor_episodee")
public class ActorEpisode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "ActorId",nullable = false)
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "episodeId",nullable = false)
    private Episode episode;
}
