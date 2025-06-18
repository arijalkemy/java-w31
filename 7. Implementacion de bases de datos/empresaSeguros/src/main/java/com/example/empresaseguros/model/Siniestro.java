package com.example.empresaseguros.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate fecha;
    private Double perdidaEconomica;

    @Column(name = "id_vehiculo_denunciado", nullable = false, insertable = false, updatable = false)
    private Long idVehiculo;
    @ManyToOne
    @JoinColumn(name = "id_vehiculo_denunciado", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Vehiculo vehiculo;
}
