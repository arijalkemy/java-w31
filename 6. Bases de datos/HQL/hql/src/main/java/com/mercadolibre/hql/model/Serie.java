package com.mercadolibre.hql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    String title;
    @Column(name = "release_date")
    LocalDateTime releaseDate;
    @Column(name = "end_date")
    LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;
    @OneToMany(mappedBy = "serie")
    private Set<Season> seasons;
}
