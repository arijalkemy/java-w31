package com.mercadolibre.showroom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClothingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;           // Código

    private String name;           // Nombre

    private String type;           // Tipo (ej: shirt, pants, etc.)

    private String brand;          // Marca

    private String color;          // Color

    private String size;           // Talle

    private Integer quantity;      // Cantidad disponible

    private Double salePrice;       // Precio de venta


}
