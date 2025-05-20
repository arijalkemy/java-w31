package com.bootcamp.movies_ejbonus.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private BigDecimal rating;
    private Integer awards;
    private Date releaseDate;
    private Integer length;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}
