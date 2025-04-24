package com.mercadolibre.groupfive.socialmeli.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    private Integer id;
    private String type;
    private String brand;
    @JsonProperty("product_name")
    private String name;
    private String color;
    private String notes;
}
