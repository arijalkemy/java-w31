package com.bootcamp.calculadoradecalorias.dto;

import com.bootcamp.calculadoradecalorias.model.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {
    private List<IngredientesDelMenuDTO> listaIngredientes;
}
