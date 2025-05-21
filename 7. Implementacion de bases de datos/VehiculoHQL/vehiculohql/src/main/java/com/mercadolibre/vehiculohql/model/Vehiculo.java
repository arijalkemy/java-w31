package com.mercadolibre.vehiculohql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "vehiculos")
public class Vehiculo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String patente;
        String marca;
        String modelo;
        @Column(name = "anio_de_fabricacion")
        Integer anioDeFabricacion;
        @Column(name = "cantidad_de_ruedas")
        Integer cantidadDeRuedas;
        @OneToMany(mappedBy = "vehiculo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        Set<Siniestro> siniestros;
}
