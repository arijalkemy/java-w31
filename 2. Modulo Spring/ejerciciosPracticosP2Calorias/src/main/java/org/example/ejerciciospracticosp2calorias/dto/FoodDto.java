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
public class FoodDto implements Serializable {
    private String name;
    private List<Ingredient> ingredientList;
    private Integer totalCalories;
    private Ingredient ingredientWithMaxCalories;

    public FoodDto(String name, List<Ingredient> ingredientList){
        this.name=name;
        this.ingredientList=ingredientList;
        this.totalCalories=0;
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredientList.add(ingredient);
    }
}
