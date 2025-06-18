package com.mercadolibre.melifrescosg9w31.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockError {
    @JsonProperty("product_id")
    private Integer productId;
    private String error;
}
