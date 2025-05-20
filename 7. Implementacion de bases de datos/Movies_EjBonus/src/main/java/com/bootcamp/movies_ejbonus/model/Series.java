package com.bootcamp.movies_ejbonus.model;

import jakarta.persistence.*;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private Date releaseDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "serie")
    private List<Season> seasons;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}
