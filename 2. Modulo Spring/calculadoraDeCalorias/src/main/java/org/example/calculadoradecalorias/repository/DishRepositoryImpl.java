package org.example.calculadoradecalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.calculadoradecalorias.entity.Dish;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class DishRepositoryImpl implements IDishRepository {

    private final List<Dish> dishes;

    public DishRepositoryImpl(List<Dish> dish) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream = getClass().getResourceAsStream("/dish.json");
        this.dishes = objectMapper.readValue(inputStream, new TypeReference<List<Dish>>() {
        });
    }

@Override
public Dish getDishByName(String name)
    {
        return dishes.stream().filter(dish -> dish.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
