package com.bootcamp.be_java_hisp_w31_g09.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DiscountDTO {
    @NotNull(message = "El descuento es obligatorio")
    @Positive(message = "El descuento debe ser un número positivo")
    private Double discount;
}
