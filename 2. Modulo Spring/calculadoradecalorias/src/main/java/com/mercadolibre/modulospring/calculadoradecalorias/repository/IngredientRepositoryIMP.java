package com.mercadolibre.modulospring.calculadoradecalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.modulospring.calculadoradecalorias.dto.IngredientDTO;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@Repository
@Getter
public class IngredientRepositoryIMP implements IngredientRepository {

        private List<IngredientDTO> data;
        public IngredientRepositoryIMP() {
            data = loadDataBase();
        }
        @Override
        public List<IngredientDTO> loadDataBase() {
            File file = null;
            try {

                file = ResourceUtils.getFile("classpath:food.json");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<IngredientDTO>> typeRef = new TypeReference<>() {};
            List<IngredientDTO> characters = null;
            try {
                characters = objectMapper.readValue(file, typeRef);
            } catch (IOException e) {
                System.out.println(e.getMessage());;
            } return characters;
        }
        @Override
        public IngredientDTO loadIngredients(String name) {
            return data.stream().filter(dto -> dto.getName().equals(name)).findFirst().orElse(null);

        }


    }

