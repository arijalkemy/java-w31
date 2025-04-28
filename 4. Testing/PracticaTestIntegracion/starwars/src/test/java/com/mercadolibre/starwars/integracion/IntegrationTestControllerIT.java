package com.mercadolibre.starwars.integracion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.mercadolibre.starwars.dto.CharacterDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestControllerIT {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void findTest() throws Exception {
        String input = "Darth";
        CharacterDTO expectedCharacter = (new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY",
                "male", "Tatooine", "Human", 202, 136));

        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", input))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(expectedCharacter.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hair_color").value(expectedCharacter.getHair_color()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].skin_color").value(expectedCharacter.getSkin_color()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].eye_color").value(expectedCharacter.getEye_color()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].birth_year").value(expectedCharacter.getBirth_year()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].gender").value(expectedCharacter.getGender()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].homeworld").value(expectedCharacter.getHomeworld()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].species").value(expectedCharacter.getSpecies()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].height").value(expectedCharacter.getHeight()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].mass").value(expectedCharacter.getMass()));

    }

    @Test
    public void findEmptyTest() throws Exception {
        String input = "Personaje inexistente";

        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", input))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(0));
    }

    @Test
    public void findNullTest() throws Exception {
        String input = null;

        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", input))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
