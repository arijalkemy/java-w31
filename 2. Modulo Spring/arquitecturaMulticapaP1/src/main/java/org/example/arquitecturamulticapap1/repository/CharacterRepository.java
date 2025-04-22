package org.example.arquitecturamulticapap1.repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.arquitecturamulticapap1.dto.CharacterDto;
import org.example.arquitecturamulticapap1.entity.CharacterEntity;
import org.springframework.stereotype.Repository;
import java.io.File;
import java.util.List;

@Repository
public class CharacterRepository {

    public List<CharacterEntity> loadCharacterData(){
        //https://www.baeldung.com/jackson-object-mapper-tutorial Revisar cuando se me olvide
        List<CharacterEntity> characterList;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            characterList = objectMapper.readValue(new File("src/main/resources/data/starwars.json"), new TypeReference<>() {});
        } catch (Exception e) {
            System.out.println("No fue posible mapear starwars.json");
            throw new RuntimeException(e);
        }
        return characterList;
    }

}
