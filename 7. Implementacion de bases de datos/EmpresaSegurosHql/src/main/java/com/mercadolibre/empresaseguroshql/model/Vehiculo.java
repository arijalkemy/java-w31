package com.mercadolibre.empresaseguroshql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int cantidadRuedas;

    public Vehiculo(String patente, String marca) {
        this.patente = patente;
        this.marca = marca;
    }

    @OneToMany(mappedBy = "vehiculo")
    private List<Siniestro> siniestros;
}
