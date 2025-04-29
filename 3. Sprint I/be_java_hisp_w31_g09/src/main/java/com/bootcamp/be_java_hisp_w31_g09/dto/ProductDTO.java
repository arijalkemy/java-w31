package com.bootcamp.be_java_hisp_w31_g09.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotNull(message = "El id del producto es obligatorio")
    @Positive(message = "El id del producto debe ser un número positivo")
    @JsonProperty("product_id")
    private Integer id;
    @NotBlank(message = "El nombre del producto es obligatorio")
    @JsonProperty("product_name")
    private String name;
    @NotBlank(message = "El tipo de producto es obligatorio")
    @JsonProperty("type")
    private String type;
    @NotBlank(message = "La marca es obligatoria")
    @JsonProperty("brand")
    private String brand;
    @NotBlank(message = "El color es obligatorio")
    @JsonProperty("color")
    private String color;
    @NotBlank(message = "La nota es obligatoria")
    @JsonProperty("notes")
    private String notes;

}
