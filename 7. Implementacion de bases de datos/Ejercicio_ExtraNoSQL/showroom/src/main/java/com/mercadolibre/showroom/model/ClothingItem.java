package com.mercadolibre.showroom.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName = "clothes")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClothingItem {

    @Id
    private String code;           // Código

    private String name;           // Nombre

    private String type;           // Tipo (ej: shirt, pants, etc.)

    private String brand;          // Marca

    private String color;          // Color

    private String size;           // Talle

    private Integer quantity;      // Cantidad disponible

    private Double salePrice;       // Precio de venta


}
