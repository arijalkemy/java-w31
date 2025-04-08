package com.mercadolibre.contadorcalorias.repository;

import com.mercadolibre.contadorcalorias.dto.DishDTO;
import com.mercadolibre.contadorcalorias.dto.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository {
    private final List<DishDTO> dishes = new ArrayList<>();

    public void save(DishDTO dish) {
        dishes.add(dish);
    }

    public List<DishDTO> findAll() {
        return dishes;
    }

    public DishDTO findByName(String name) {
        return dishes.stream()
                .filter(d -> d.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}

