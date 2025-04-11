package org.example.calculadoradecalorias.controller;

import org.example.calculadoradecalorias.dto.IngredientsDto;
import org.example.calculadoradecalorias.entity.Dish;
import org.example.calculadoradecalorias.repository.IDishRepository;
import org.example.calculadoradecalorias.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private IRestaurantService restaurantService;

    @GetMapping("/{dishName}")
    public List<IngredientsDto> getCaloriesByDish(@PathVariable String dishName) throws IOException {


        return restaurantService.getIngredientsByDish(dishName);
    }
}
