package com.mercadolibre.hql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    String name;
    Integer ranking;
    Integer active;
    @OneToMany(mappedBy = "genre")
    private Set<Serie> series;
    @OneToMany(mappedBy = "genre")
    private Set<Movie> movies;
}
