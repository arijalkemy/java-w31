package com.mercadolibre.movieshql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "seasons")
@Data
public class Season {
    @Id
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String title;

    private Integer number;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serie_id")
    @JsonIgnore
    private Serie serie;

    @OneToMany(mappedBy = "season")
    private Set<Episode> episodes = new HashSet<>();

    // Getters y setters
}
