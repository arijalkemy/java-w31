package com.starwarscharacter.starwars.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwarscharacter.starwars.entity.StarCharacter;

@Repository
public class StarRepository implements IStarRepository {
   private List<StarCharacter> stars = new ArrayList<>();
   private final ObjectMapper mapper;

   public StarRepository(ObjectMapper mapper) throws IOException {

      this.mapper = mapper;
      loadDataBase();
   }

   private void loadDataBase() throws IOException {
      File file;
      file = ResourceUtils.getFile("classpath:starwars.json");
      stars = mapper.readValue(file, new TypeReference<List<StarCharacter>>() {
      });
   }

   @Override
   public List<StarCharacter> getallcharacters() {
      return stars;
   }

   @Override
   public List<StarCharacter> getByName(String name) {
      return stars.stream().filter(s -> s.getName().toLowerCase().contains(name.toLowerCase())).toList();
   }
}
