package com.mercadolibre.melifrescosg9w31.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequestDTO {

    @Size(min = 3, max = 50, message = "The product name must be between 3 y 50 characters")
    @JsonProperty("product_name")
    private String productName;

    @Size(min = 10, max = 255, message = "The product description must be between 50 y 255 characters")
    @JsonProperty("product_description")
    private String productDescription;

    @DecimalMin(value = "0.0", message = "The price must be positive")
    @JsonProperty("product_price")
    private BigDecimal productPrice;
}
