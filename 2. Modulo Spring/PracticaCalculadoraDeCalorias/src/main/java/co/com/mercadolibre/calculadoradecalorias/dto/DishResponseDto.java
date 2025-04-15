package co.com.mercadolibre.calculadoradecalorias.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DishResponseDto {
    private int totalCalories;
    private List<IngredientDto> ingredients;
    private IngredientDto highestCalorieIngredient;

    public DishResponseDto() {
        this.ingredients = new ArrayList<>();
    }
}
