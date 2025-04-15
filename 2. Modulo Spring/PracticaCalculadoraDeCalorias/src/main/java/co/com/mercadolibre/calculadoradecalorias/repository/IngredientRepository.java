package co.com.mercadolibre.calculadoradecalorias.repository;

import java.util.List;

import co.com.mercadolibre.calculadoradecalorias.dto.IngredientDto;

public interface IngredientRepository {

    List<IngredientDto> findAll();
}
