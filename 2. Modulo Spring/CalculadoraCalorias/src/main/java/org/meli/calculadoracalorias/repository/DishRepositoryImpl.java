package org.meli.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.meli.calculadoracalorias.model.Dish;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class DishRepositoryImpl {

    private final List<Dish> dishes;

    public DishRepositoryImpl() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Dish>> typeRef = new TypeReference<List<Dish>>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/food.json");
        dishes = mapper.readValue(inputStream, typeRef);
    }

    public List<Dish> getAllDishes() {
        return dishes;
    }
}
