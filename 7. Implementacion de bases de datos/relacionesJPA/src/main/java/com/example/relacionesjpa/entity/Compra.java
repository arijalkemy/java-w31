package com.example.relacionesjpa.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Id
    private LocalDate date;
}
