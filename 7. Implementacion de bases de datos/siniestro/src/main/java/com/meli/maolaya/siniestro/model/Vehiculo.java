package com.meli.maolaya.siniestro.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer añoFabricacion;
    private Integer ruedas;
    @OneToMany(mappedBy = "vehiculo")
    @ToString.Exclude
    private List<Siniestro> siniestros;
}
