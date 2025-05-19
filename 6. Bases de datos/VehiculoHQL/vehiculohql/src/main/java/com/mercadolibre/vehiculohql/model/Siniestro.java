package com.mercadolibre.vehiculohql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "fecha_del_siniestro")
    LocalDate fechaDelSiniestro;
    @Column(name = "perdida_economica")
    Double perdidaEconomica;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo_id")
    Vehiculo vehiculo;
}
