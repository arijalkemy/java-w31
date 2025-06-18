package com.mercadolibre.melifrescosg9w31.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInOrderDTO {
    private Long id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
}
