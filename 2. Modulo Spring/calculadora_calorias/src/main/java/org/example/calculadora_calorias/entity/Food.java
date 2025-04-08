package org.example.calculadora_calorias.entity;

import lombok.Data;

import java.util.List;

@Data
public class Food {
    private String name;
    private List<String> ingredients;
}
