package org.mercadolibre.showroom.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clothes")
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", unique = true)
    private String codigo;

    @Column(name = "name")
    private String nombre;

    @Column(name = "type")
    private String tipo;

    @Column(name = "brand")
    private String marca;

    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private String talle;

    @Column(name = "quantity")
    private int cantidad;

    @Column(name = "price")
    private double precioVenta;
}
