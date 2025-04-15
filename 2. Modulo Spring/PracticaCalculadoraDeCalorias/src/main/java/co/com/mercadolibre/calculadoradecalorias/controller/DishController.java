package co.com.mercadolibre.calculadoradecalorias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.mercadolibre.calculadoradecalorias.dto.DishListResponseDto;
import co.com.mercadolibre.calculadoradecalorias.dto.DishResponseDto;
import co.com.mercadolibre.calculadoradecalorias.service.DishService;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping("/single")
    public DishResponseDto getDishDetails(@RequestBody List<String> ingredientNames) {
        return dishService.calculateDish(ingredientNames);
    }

    @PostMapping("/multiple")
    public DishListResponseDto getDishListDetails(@RequestBody List<List<String>> dishes) {
        return dishService.calculateDishList(dishes);
    }
}
