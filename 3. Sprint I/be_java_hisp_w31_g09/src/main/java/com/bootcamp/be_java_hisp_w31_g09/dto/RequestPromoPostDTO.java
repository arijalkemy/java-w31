package com.bootcamp.be_java_hisp_w31_g09.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestPromoPostDTO {
    @NotNull(message = "El User id es obligatorio")
    @Positive(message = "El User id debe ser un número positivo")
    @JsonProperty("user_id")
    private Integer userId;
    @NotBlank(message = "La fecha es obligatoria")
    @JsonProperty("date")
    private String date;
    @NotNull(message = "El producto es obligatorio")
    @JsonProperty("product")
    @Valid
    private ProductDTO product;
    @NotNull(message = "La categoria es obligatoria")
    @Positive(message = "El categoria debe ser un número positivo")
    @JsonProperty("category")
    private Integer category;
    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser un número positivo")
    @JsonProperty("price")
    private Double price;
    @NotNull(message = "La promocion es obligatoria")
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    @NotNull(message = "El descuento es obligatorio")
    @Positive(message = "El descuento debe ser un número positivo")
    @JsonProperty("discount")
    private Double discount;
}
