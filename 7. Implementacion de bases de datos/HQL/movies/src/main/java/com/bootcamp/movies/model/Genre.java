package com.bootcamp.movies.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "created_at", nullable = false)
    @NotNull(message = "La fecha de creación no puede ser nula.")
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @NotNull(message = "La fecha de última actualización no puede ser nula.")
    private Date updatedAt;

    @Column(length = 100, nullable = false)
    @NotNull(message = "El nombre del género no puede ser nulo.")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres.")
    private String name;

    @Positive
    private Integer ranking;

    @NotNull
    private Boolean active;

    @OneToMany(mappedBy = "genre_film")
    private List<Movie> genreMovies;

    @OneToMany(mappedBy = "genre_serie")
    private List<Serie> genreSeries;
}
