package com.mercadolibre.miniseries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String title;
    private Integer number;
    private Date releaseDate;
    private Double rating;

    @OneToMany
    private Set<ActorEpisode> actorEpisodes;

    @ManyToOne
    @JoinColumn(name = "seasonId",nullable = false)
    private Season season;

}
