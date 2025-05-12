package com.mercadolibre.groupfive.socialmeli.dto;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {

    @JsonProperty("product_id")
    @NotNull(message = "{notnull}")
    @Min(value = 1, message = "{minimum.id.allowed}")
    private Integer id;

    @NotBlank(message = "{notblank}")
    @Size(max = 15, message = "{max.length}")
    @Pattern( regexp = "^(?! )[a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ]+(?: [a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ]+)*(?<! )$", 
    message = "{special.characters}")
    private String type;

    @NotBlank(message = "{notblank}")
    @Size(max = 25, message = "{max.length}")
    @Pattern( regexp = "^(?! )[a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ]+(?: [a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ]+)*(?<! )$", 
    message = "{special.characters}")
    private String brand;

    @JsonProperty("product_name")
    @NotBlank(message = "{notblank}")
    @Size(max = 40, message = "{max.length}")
    @Pattern( regexp = "^(?! )[a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ]+(?: [a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ]+)*(?<! )$",
    message = "{special.characters}")
    private String name;

    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max = 15, message = "{max.length}")
    @Pattern( regexp = "^(?! )[a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ]+(?: [a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ]+)*(?<! )$", 
    message = "{special.characters}")
    private String color;

    @Size(max = 80, message = "{max.length}")
    @Pattern( regexp = "^(?! )[a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ]+(?: [a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ]+)*(?<! )$", 
    message = "{special.characters}")
    private String notes;
}
