package com.mercadolibre.showroom_uno.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "clothes")
public class Clothe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "codigo")
    private Long id;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talle;
    private Integer cantidad;
    @Column (name = "precio_venta")
    private Double precioVenta;
    @OneToMany(mappedBy = "clothe")
    private List<SaleClothe> saleClothes;
}
