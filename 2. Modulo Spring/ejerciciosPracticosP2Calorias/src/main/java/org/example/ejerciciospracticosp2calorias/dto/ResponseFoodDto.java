package org.example.ejerciciospracticosp2calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.ejerciciospracticosp2calorias.entity.Ingredient;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponseFoodDto implements Serializable {
    private Integer totalCalories;
    private List<Ingredient> ingredientList;
    private Ingredient ingredientWithMaxCalories;
}
