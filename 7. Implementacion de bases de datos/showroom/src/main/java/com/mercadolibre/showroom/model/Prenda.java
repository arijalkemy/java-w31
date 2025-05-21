package com.mercadolibre.showroom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Table(name = "prendas")
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    private String tipo;
    private String marca;
    private String color;
    private String talle;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "precio_venta", nullable = false)
    private BigDecimal precio;
}
