package com.mercadolibre.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // No incluye campos null.
public class SportDto implements Serializable {

    private String name;
    private String level;

    public SportDto(String level){
        this.level = level;
    }



}
