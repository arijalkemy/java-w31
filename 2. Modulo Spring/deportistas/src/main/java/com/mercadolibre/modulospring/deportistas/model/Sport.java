package com.mercadolibre.modulospring.deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Sport {
    private String name;
    private String level;

    @Override
    public String toString() {
        return "Sport{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}

