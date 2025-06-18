package com.example.consultashql.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "seasons")
@Data
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String title;
    private Integer number;
    private LocalDateTime releaseDate;
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

}
