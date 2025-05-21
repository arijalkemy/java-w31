package com.mercadolibre.showroom.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClothingItemDto {

    private String code;            // Código

    private String name;           // Nombre

    private String type;           // Tipo (ej: shirt, pants, etc.)

    private String brand;          // Marca

    private String color;          // Color

    private String size;           // Talle

    private Integer quantity;      // Cantidad disponible

    private Double salePrice;      // Precio de venta
}
