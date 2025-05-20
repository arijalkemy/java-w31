package com.mercadolibre.movies.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "actors")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(precision = 3, scale = 1)
    private BigDecimal rating;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id", referencedColumnName = "id")
    private Movie favoriteMovie;

    @OneToMany(mappedBy = "actor")
    private List<ActorMovie> actorMovies;

}
