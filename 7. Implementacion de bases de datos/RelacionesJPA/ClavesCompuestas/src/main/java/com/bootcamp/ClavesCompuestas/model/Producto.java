package com.bootcamp.ClavesCompuestas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Producto {
     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idProducto;
    
    @Column(length = 50, nullable = false)
    @NotNull(message = "El nombre del producto no puede ser nulo.")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres.")
    private String nombre;

    @Column(length = 100, nullable = false)
    @NotNull(message = "La descripcion del producto no puede ser nulo.")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres.")
    private String descripcion;

    @ManyToMany(mappedBy = "productos")
    private List<Compra> compras;
}
