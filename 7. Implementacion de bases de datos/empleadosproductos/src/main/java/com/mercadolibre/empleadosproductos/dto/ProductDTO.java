package com.mercadolibre.empleadosproductos.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private String name;
    private String type;
    private Double salePrice;
    private Double costPrice;
    private Integer stock;
}
