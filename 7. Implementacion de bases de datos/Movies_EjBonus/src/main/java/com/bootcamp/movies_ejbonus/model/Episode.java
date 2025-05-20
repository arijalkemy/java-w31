package com.bootcamp.movies_ejbonus.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private Integer number;
    private Date releaseDate;
    private BigDecimal rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}

