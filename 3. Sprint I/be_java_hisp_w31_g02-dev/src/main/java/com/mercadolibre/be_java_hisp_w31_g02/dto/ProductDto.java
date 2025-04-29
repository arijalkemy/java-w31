package com.mercadolibre.be_java_hisp_w31_g02.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    
    @NotNull(message = "The product_id must not be null")
    private Integer product_id;
    
    @NotNull(message = "The product_id must not be null")
    private String product_name;
    
    private String type;
    private String brand;
    private String color;
    private String notes;


}
