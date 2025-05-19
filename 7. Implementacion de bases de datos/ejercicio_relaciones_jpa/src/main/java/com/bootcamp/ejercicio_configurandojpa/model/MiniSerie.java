package com.bootcamp.ejercicio_configurandojpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private String name;
    private Double rating;

    @Column(name = "amount_of_awards")
    private int amountAwards;

    @OneToMany(mappedBy = "miniSerie", fetch = FetchType.LAZY)
    private List<Episode> episodes;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        name = "mini_serie_actor",
        joinColumns = @JoinColumn(name = "mini_serie_id"),
        inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;
}
