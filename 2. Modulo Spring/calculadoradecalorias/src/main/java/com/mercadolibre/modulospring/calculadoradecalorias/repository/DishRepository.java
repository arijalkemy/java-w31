package com.mercadolibre.modulospring.calculadoradecalorias.repository;

import com.mercadolibre.modulospring.calculadoradecalorias.dto.DishDTO;
import com.mercadolibre.modulospring.calculadoradecalorias.dto.DishResponseDTO;
import com.mercadolibre.modulospring.calculadoradecalorias.dto.IngredientDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
@Getter

public class DishRepository {
    private List<DishResponseDTO> data;
    public DishRepository() {
        data=new ArrayList<>();
    }
    public void add(DishResponseDTO dish) {
        data.add(dish);
    }


}
