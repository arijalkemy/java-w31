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
    @NotNull(message = "El id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero")
    @JsonProperty("user_id")
    private Integer userId;
    @NotBlank(message = "La fecha no puede estar vacía.")
    @JsonProperty("date")
    private String date;
    @NotNull(message = "El producto es obligatorio")
    @JsonProperty("product")
    @Valid
    private ProductDTO product;
    @NotNull(message = "El campo no puede estar vacío.")
    @JsonProperty("category")
    private Integer category;
    @NotNull(message = "El campo no puede estar vacío.")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
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
