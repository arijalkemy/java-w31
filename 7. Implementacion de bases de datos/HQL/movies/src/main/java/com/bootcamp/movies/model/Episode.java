package com.bootcamp.movies.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
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
public class Episode {
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
    @NotNull(message = "El título del episodio no puede ser nulo.")
    @Size(min = 2, max = 500, message = "El título debe tener entre 2 y 500 caracteres.")
    private String title;

    @Positive
    private Integer number;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @PositiveOrZero
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "id")
    private Season season;
}
