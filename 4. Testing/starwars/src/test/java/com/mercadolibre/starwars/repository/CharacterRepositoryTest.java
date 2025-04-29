package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryTest {

    CharacterRepositoryImpl characterRepository;

    @BeforeEach
    public void sepUt(){
        characterRepository = new CharacterRepositoryImpl();
    }
    @Test
    void findAllByNameContains(){
        //Arrange
        String query = "Luke";

        //Act
        List<CharacterDTO> list= characterRepository.findAllByNameContains(query);

        //Assert
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }
}
