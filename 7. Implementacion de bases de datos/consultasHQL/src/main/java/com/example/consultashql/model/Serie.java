package com.example.consultashql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "series")
@Data
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String title;
    private LocalDateTime releaseDate;
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

}
