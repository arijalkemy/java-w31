package com.mercadolibre.hql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Entity
@Table(name = "actor_episode")
public class ActorEpisode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;
    @ManyToOne
    @JoinColumn(name = "episode_id", nullable = false)
    private Episode episode;
}
