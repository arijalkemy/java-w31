package com.bootcamp.ejercicio_configurandojpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double duration;

    @ManyToOne
    @JoinColumn(name = "mini_serie_id")
    private MiniSerie miniSerie;
}
