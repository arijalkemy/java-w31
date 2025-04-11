package org.example.personajesstarwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.example.personajesstarwars.entity.CharacterEntity;
import org.example.personajesstarwars.utils.deserialize.IntNAHandler;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class CharacterRepository implements ICharacterRepository {
    @Override
    public List<CharacterEntity> loadCharactersFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Integer.class, new IntNAHandler());
        objectMapper.registerModule(module);
        InputStream inputStream = getClass().getResourceAsStream("/starwars.json");
        return objectMapper.readValue(inputStream, new TypeReference<List<CharacterEntity>>(){});
    }
}
