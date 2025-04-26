package com.bootcamp.calculadoradecalorias.dto;

import com.bootcamp.calculadoradecalorias.model.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    private double caloriasTotales;
    private List<Food> listaIngredientes;
    private Food ingredienteMasCalorico;

    public void setCaloriasTotales(double caloriasTotales) {
        this.caloriasTotales += caloriasTotales;
    }

    public void setListaIngredientes(Food ingrediente) {
        if (this.listaIngredientes == null) {
            this.listaIngredientes = new ArrayList<>();
        }
        this.listaIngredientes.add(ingrediente);    }
}
