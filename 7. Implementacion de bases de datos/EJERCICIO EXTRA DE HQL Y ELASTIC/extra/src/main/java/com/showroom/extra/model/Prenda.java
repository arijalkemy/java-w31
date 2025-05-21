package com.showroom.extra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prendas")
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long codigo;
    private String nombre, tipo, marca,color,talle;
    private Integer cantidad;
    private Double precioVenta;

    @ManyToMany(mappedBy = "prendas")
    @JsonIgnore
    private List<Venta> ventas;
}
