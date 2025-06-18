package com.example.consultashql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "episodes")
@Data
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String title;
    private Integer number;
    private LocalDateTime releaseDate;
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @ManyToMany(mappedBy = "episodes")
    private Set<Actor> actors;

}
