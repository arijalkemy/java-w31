package com.mercadolibre.starwars.unittest.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.unittest.utils.SetTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FindServiceTests {

    @Mock
    private CharacterRepository characterRepository;
    @InjectMocks
    private FindService service;
    private final SetTests set = new SetTests();
    private final List<CharacterDTO> characterDTOList = set.listForDarth();

    @Test
    public void testFindCharacters(){
        //param
        List<CharacterDTO> expected = characterDTOList;
        String name = "Darth";

        //act
        when(service.find(name)).thenReturn(expected);
        List<CharacterDTO> characterDTOS = service.find(name);
        //assert
        assertEquals(expected, characterDTOS);
    }

    @Test
    public void testEmptyList(){
        List<CharacterDTO> expected = new ArrayList<>();
        String name = "Doe";

        //act
        when(service.find(name)).thenReturn(expected);
        List<CharacterDTO> characterDTOS = service.find(name);
        //assert
        assertEquals(expected, characterDTOS);
    }
}
