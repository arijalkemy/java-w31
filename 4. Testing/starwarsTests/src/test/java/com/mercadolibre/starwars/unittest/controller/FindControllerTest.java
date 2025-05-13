package com.mercadolibre.starwars.unittest.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.unittest.utils.SetTests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    private static FindService  service;
    @InjectMocks
    private static FindController controller;

    private final SetTests set = new SetTests();
    private final List<CharacterDTO> characterDTOList = set.listForDarth();

    @Test
    public void testFindCharacters(){
        //param
        List<CharacterDTO> expected = characterDTOList;
        String name = "Darth";

        when(controller.find(name)).thenReturn(expected);
        List<CharacterDTO> characterDTOS = controller.find(name);
        assertEquals(expected, characterDTOS);
    }

}
