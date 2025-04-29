package com.bootcamp.be_java_hisp_w31_g09.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestPostDTO {
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
    @JsonProperty("category")
    private Integer category;
    @NotNull(message = "El precio es obligatorio")
    @JsonProperty("price")
    private Double price;
}
