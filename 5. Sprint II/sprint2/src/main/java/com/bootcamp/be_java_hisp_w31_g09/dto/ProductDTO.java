package com.bootcamp.be_java_hisp_w31_g09.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a cero")
    @JsonProperty("product_id")
    private Integer id;
    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 áéíóúÁÉÍÓÚñÑ]*$", message = "El campo no puede poseer caracteres especiales.")
    @JsonProperty("product_name")
    private String name;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 áéíóúÁÉÍÓÚñÑ]*$", message = "El campo no puede poseer caracteres especiales.")
    @JsonProperty("type")
    private String type;
    @NotBlank(message = "La marca es obligatoria")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 áéíóúÁÉÍÓÚñÑ]*$", message = "El campo no puede poseer caracteres especiales.")
    @JsonProperty("brand")
    private String brand;
    @NotBlank(message = "El color es obligatorio")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 áéíóúÁÉÍÓÚñÑ]*$", message = "El campo no puede poseer caracteres especiales.")
    @JsonProperty("color")
    private String color;
    @NotBlank(message = "La nota es obligatoria")
    @Size(max = 80, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 áéíóúÁÉÍÓÚñÑ]*$", message = "El campo no puede poseer caracteres especiales.")
    @JsonProperty("notes")
    private String notes;

}
