package org.example.ejerciciospracticosp2calorias.service;
import org.example.ejerciciospracticosp2calorias.dto.FoodDto;
import org.example.ejerciciospracticosp2calorias.dto.RequestFoodDto;
import org.example.ejerciciospracticosp2calorias.dto.ResponseFoodDto;
import org.example.ejerciciospracticosp2calorias.entity.Ingredient;
import org.example.ejerciciospracticosp2calorias.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoodServiceImp implements FoodService{

    @Autowired
    FoodRepository foodRepository;

    public List<ResponseFoodDto> getIngredientsPerProduct(RequestFoodDto requestFoodDto){
        List<Ingredient> ingredientList = foodRepository.loadIngredientData();
        List<FoodDto> foodDtoList = foodRepository.loadFoodData(ingredientList);

        List<FoodDto> foodDtoListWithFilter=findFood(requestFoodDto.getName(),foodDtoList);

        calculateTotalCalories(foodDtoListWithFilter);
        setIngredientWithMaxCalories(foodDtoListWithFilter);
        return convertEntityToDto(foodDtoListWithFilter);
    }

    public List<ResponseFoodDto> convertEntityToDto(List<FoodDto> foodDtoList){
        return foodDtoList.stream().map(food -> new ResponseFoodDto(
            food.getTotalCalories(),
                food.getIngredientList(),
                food.getIngredientWithMaxCalories()
        )).toList();
    }

    public void calculateTotalCalories(List<FoodDto> foodDtoList){
        foodDtoList.forEach(foodDto -> foodDto.setTotalCalories(
                foodDto.getIngredientList().stream().mapToInt(Ingredient::getCalories).sum()));
    }

    public void setIngredientWithMaxCalories(List<FoodDto> foodDtoList){
        for(FoodDto foodDto: foodDtoList){
            Ingredient ingredientAuxMax= foodDto.getIngredientList().get(0);
            for(Ingredient ingredient: foodDto.getIngredientList()){
                if(ingredient.getCalories()>ingredientAuxMax.getCalories()){
                    ingredientAuxMax = ingredient;
                }
            }
            foodDto.setIngredientWithMaxCalories(ingredientAuxMax);
        }
    }

    public List<FoodDto> findFood(String name, List<FoodDto> foodDtoList){
        return foodDtoList.stream().filter(foodDto ->
                foodDto.getName().contains(name)).toList();
    }
}
