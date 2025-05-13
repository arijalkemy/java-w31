package com.mercadolibre.starwars.unittest.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.unittest.utils.SetTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CharacterRepositoryImplTest {

    private final CharacterRepository repository = new CharacterRepositoryImpl();
    private final SetTests set = new SetTests();
    private final List<CharacterDTO> characterDTOList = set.listForDarth();


    @Test
    public void testFindAllByName(){
        String name = "Darth";
        List<CharacterDTO> characterDTOS = repository.findAllByNameContains(name);
        assertEquals(characterDTOList,characterDTOS);
    }

}
