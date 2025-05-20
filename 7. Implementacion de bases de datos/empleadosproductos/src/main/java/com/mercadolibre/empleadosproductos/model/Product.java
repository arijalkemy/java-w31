package com.mercadolibre.empleadosproductos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private String type; // e.g. food, cleaning, etc.
    private Double salePrice;
    private Double costPrice;
    private Integer stock;
}
