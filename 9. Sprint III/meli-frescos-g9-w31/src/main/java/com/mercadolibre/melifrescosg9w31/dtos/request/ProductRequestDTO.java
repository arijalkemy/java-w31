package com.mercadolibre.melifrescosg9w31.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.melifrescosg9w31.entity.ProductType;
import com.mercadolibre.melifrescosg9w31.entity.Seller;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    @NotBlank(message = "Product name cannot be null.")
    @JsonProperty("product_name")
    private String name;

    @NotBlank(message = "Description cannot be null.")
    @JsonProperty("product_description")
    private String description;

    @NotNull(message = "Price cannot be null.")
    @Positive
    @JsonProperty("product_price")
    private BigDecimal price;

    @NotNull(message = "Product type cannot be null.")
    @JsonProperty("product_type")
    private ProductType productType;

    @NotNull(message = "Seller cannot be null.")
    @JsonProperty("product_seller")
    private Seller seller;
}
