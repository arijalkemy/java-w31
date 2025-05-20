package com.bootcamp.movies.model;

import java.util.Date;
import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "created_at", nullable = false)
    @NotNull(message = "La fecha de creación no puede ser nula.")
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @NotNull(message = "La fecha de última actualización no puede ser nula.")
    private Date updatedAt;

    @Column(length = 500, nullable = false)
    @NotNull(message = "El título de la película no puede ser nulo.")
    @Size(min = 2, max = 500, message = "El título debe tener entre 2 y 500 caracteres.")
    private String title;

    @PositiveOrZero
    private Double rating;

    @PositiveOrZero
    private Integer awards;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @PositiveOrZero
    private Integer length;

    @OneToMany(mappedBy = "favorite_movie")
    private List<Actor> favoredBy;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;
}
