package co.com.mercadolibre.calculadoradecalorias.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.mercadolibre.calculadoradecalorias.dto.IngredientDto;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

    List<IngredientDto> ingredientList = new ArrayList<>();

    public IngredientRepositoryImpl() throws IOException {
        loadDb();
    }

    @Override
    public List<IngredientDto> findAll(){
        return ingredientList;
    }

    public void loadDb() throws IOException{
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<IngredientDto> ingredientDtos;
        file= ResourceUtils.getFile("classpath:food.json");
        ingredientDtos= objectMapper.readValue(file, new TypeReference<List<IngredientDto>>() {});
        ingredientList = ingredientDtos;        
    } 
    
}
