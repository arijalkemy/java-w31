package com.mercadolibreexample.starwarnames.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibreexample.starwarnames.Entity.Personaje;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository implements IRepository {
    @Override
    public List<Personaje> LoadData() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("data.json")) {
            return mapper.readValue(is, new TypeReference<List<Personaje>>() {});
        }
        catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
