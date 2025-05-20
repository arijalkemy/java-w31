package com.bootcamp.movies_ejbonus.model;

import jakarta.persistence.*;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private Integer number;
    private Date releaseDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Series serie;

    @OneToMany(mappedBy = "season")
    private List<Episode> episodes;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}

