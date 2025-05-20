package com.mercadolibre.miniseries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String matricula;
    private String marca;
    private String modelo;
    private Long anoFabricacion;
    private Integer numRuedas;

    @OneToMany(mappedBy = "vehicle")
    private List<Siniestro> siniestros;

}
