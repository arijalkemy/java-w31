package com.example.hqlenvivo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    private LocalDate date;
    private Double monetaryLoss;
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehiculo vehicle;
}
