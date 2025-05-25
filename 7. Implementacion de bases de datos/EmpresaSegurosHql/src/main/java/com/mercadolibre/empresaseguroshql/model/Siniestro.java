package com.mercadolibre.empresaseguroshql.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;
}
