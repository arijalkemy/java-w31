package com.mercadolibre.be_java_hisp_w31_g02.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    
    @NotNull(message = "The product_id must not be null")
    @Min(value = 1, message = "The product_id must be positive")
    private Integer product_id;
    
    @NotNull(message = "The product_id must not be null")
    @Size(max = 40, message = "The product_name must be at least 40 characters long")
    private String product_name;

    @NotNull(message = "The type field cannot be null")
    @Size(max = 15, message = "The type field cannot have more than 15 characters")
    private String type;

    @NotNull(message = "The brand field cannot be null")
    @Size(max = 25, message = "The brand field cannot have more than 25 characters.")
    private String brand;

    @NotNull(message = "The color field cannot be null")
    @Size(max = 15, message = "The color field cannot have more than 15 characters.")
    private String color;

    @Size(max = 80, message = "The notes field cannot have more than 80 characters.")
    private String notes;

}
