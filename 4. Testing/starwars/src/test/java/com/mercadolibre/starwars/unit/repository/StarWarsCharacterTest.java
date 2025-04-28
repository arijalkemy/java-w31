package com.mercadolibre.starwars.unit.repository;

import com.mercadolibre.starwars.entity.StarWarsCharacter;
import com.mercadolibre.starwars.repository.StarWarsCharacterRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StarWarsCharacterTest {

    @Autowired
    private StarWarsCharacterRepository repository;

    @Test
    public void getCharacters_shouldReturnCharacterList() throws Exception {
       // Arrange
        List<StarWarsCharacter> charactersExpected = new ArrayList<>();
        charactersExpected.add( new StarWarsCharacter("Darth Vader", 202, 136, "none", "white",
                "yellow", "41.9BBY", "male", "Tatooine", "Human"));
        charactersExpected.add(  new StarWarsCharacter("Darth Maul", 175, 80, "none", "red",
                "yellow", "54BBY", "male", "Dathomir", "Dathomirian"));
        charactersExpected.add(new StarWarsCharacter("Luke Skywalker", 172, 77, "blond", "fair",
                "blue", "19BBY", "male", "Tatooine", "Human"));


        // Act
        List<StarWarsCharacter> characters = repository.getCharacters();

        // Assert
        assertTrue(characters.containsAll(charactersExpected));
    }


}