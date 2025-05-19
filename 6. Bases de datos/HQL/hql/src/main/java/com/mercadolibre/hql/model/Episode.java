package com.mercadolibre.hql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    String title;
    Integer number;
    @Column(name = "release_date")
    LocalDateTime releaseDate;
    Double rating;
    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;
    @OneToMany(mappedBy = "episode")
    private Set<ActorEpisode> actors_episodes;
}
