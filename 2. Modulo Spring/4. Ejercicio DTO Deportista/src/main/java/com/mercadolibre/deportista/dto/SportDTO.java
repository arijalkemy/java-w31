package com.mercadolibre.deportista.dto;

import lombok.Data;


@Data
public class SportDTO {
    private String name;

    public SportDTO() {
    }

    public SportDTO(String name) {
        this.name = name;
    }
}
