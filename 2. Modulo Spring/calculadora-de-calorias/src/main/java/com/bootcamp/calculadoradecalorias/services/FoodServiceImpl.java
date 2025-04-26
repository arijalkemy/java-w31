package com.bootcamp.calculadoradecalorias.services;

import com.bootcamp.calculadoradecalorias.dto.FoodDTO;
import com.bootcamp.calculadoradecalorias.dto.IngredientesDelMenuDTO;
import com.bootcamp.calculadoradecalorias.dto.MenuDTO;
import com.bootcamp.calculadoradecalorias.model.Food;
import com.bootcamp.calculadoradecalorias.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@Service
public class FoodServiceImpl implements IFoodService{
    @Autowired
    IFoodRepository foodRepository;

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public FoodDTO findByIngredients(MenuDTO menuDTO) {

        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setIngredienteMasCalorico(new Food());
        List<Food> listaIngredientes = foodRepository.findAll();
        for(IngredientesDelMenuDTO menu : menuDTO.getListaIngredientes() ){
            for(Food ingrediente : listaIngredientes){
                if(menu.getName().equals(ingrediente.getName())){
                    foodDTO.setListaIngredientes(ingrediente);
                    foodDTO.setCaloriasTotales(ingrediente.getCalories());
                    if(ingrediente.getCalories() > foodDTO.getIngredienteMasCalorico().getCalories()) {
                        foodDTO.setIngredienteMasCalorico(ingrediente);
                    }
                }
            }
        }
        return foodDTO;
    }
}
