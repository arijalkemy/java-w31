package com.mercadolibre.miniseries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String name;
    private Integer ranking;
    private Boolean active;

    @OneToMany
    private Set<Serie> series;

    @OneToMany
    private Set<Movie> movies;

}
