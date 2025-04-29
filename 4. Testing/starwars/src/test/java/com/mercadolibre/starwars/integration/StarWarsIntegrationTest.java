package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StarWarsIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void findCharacters_WithLuke_ShouldReturnLukeSkywalker() throws Exception {
        // Act
        MvcResult result = mockMvc.perform(get("/Luke"))
                .andExpect(status().isOk())
                .andReturn();

        List<CharacterDTO> characters = objectMapper.readValue(
                result.getResponse().getContentAsString(),
                new TypeReference<List<CharacterDTO>>() {});

        // Assert
        assertEquals(1, characters.size());

        CharacterDTO luke = characters.get(0);
        assertEquals("Luke Skywalker", luke.getName());
        assertEquals(172, luke.getHeight());
        assertEquals(77, luke.getMass());
        assertEquals("blond", luke.getHair_color());
    }

    @Test
    void findCharacters_WithDarth_ShouldReturnTwoCharacters() throws Exception {
        // Act
        MvcResult result = mockMvc.perform(get("/Darth"))
                .andExpect(status().isOk())
                .andReturn();

        List<CharacterDTO> characters = objectMapper.readValue(
                result.getResponse().getContentAsString(),
                new TypeReference<List<CharacterDTO>>() {});

        // Assert
        assertEquals(2, characters.size());
        assertTrue(characters.stream().anyMatch(c -> c.getName().equals("Darth Vader")));
        assertTrue(characters.stream().anyMatch(c -> c.getName().equals("Darth Maul")));
    }

    @Test
    void findCharacters_WithNonExistent_ShouldReturnEmptyList() throws Exception {
        // Act
        MvcResult result = mockMvc.perform(get("/NonExistentCharacter"))
                .andExpect(status().isOk())
                .andReturn();

        List<CharacterDTO> characters = objectMapper.readValue(
                result.getResponse().getContentAsString(),
                new TypeReference<List<CharacterDTO>>() {});

        // Assert
        assertEquals(0, characters.size());
    }

    @Test
    void findCharactersWithEmptyQueryShouldReturnFullList() throws Exception {
        // Act
        MvcResult result = mockMvc.perform(get("/ "))
                .andExpect(status().isOk())
                .andReturn();

        List<CharacterDTO> characters = objectMapper.readValue(
                result.getResponse().getContentAsString(),
                new TypeReference<List<CharacterDTO>>() {});

        // Assert
        assertEquals(63, characters.size());
    }

    @Test
    void findCharacters_CaseInsensitiveSearch_ShouldWork() throws Exception {
        // Act - lowercase
        MvcResult result1 = mockMvc.perform(get("/luke"))
                .andExpect(status().isOk())
                .andReturn();

        List<CharacterDTO> characters1 = objectMapper.readValue(
                result1.getResponse().getContentAsString(),
                new TypeReference<List<CharacterDTO>>() {});

        // Act - uppercase
        MvcResult result2 = mockMvc.perform(get("/LUKE"))
                .andExpect(status().isOk())
                .andReturn();

        List<CharacterDTO> characters2 = objectMapper.readValue(
                result2.getResponse().getContentAsString(),
                new TypeReference<List<CharacterDTO>>() {});

        // Assert
        assertEquals(1, characters1.size());
        assertEquals(1, characters2.size());
        assertEquals("Luke Skywalker", characters1.get(0).getName());
        assertEquals("Luke Skywalker", characters2.get(0).getName());
    }

    @Test
    void findCharacters_PartialNameSearch_ShouldWork() throws Exception {
        // Act
        MvcResult result = mockMvc.perform(get("/Sky"))
                .andExpect(status().isOk())
                .andReturn();

        List<CharacterDTO> characters = objectMapper.readValue(
                result.getResponse().getContentAsString(),
                new TypeReference<List<CharacterDTO>>() {});

        // Assert
        assertEquals(3, characters.size());
        assertTrue(characters.stream().anyMatch(c -> c.getName().equals("Luke Skywalker")));
        assertTrue(characters.stream().anyMatch(c -> c.getName().equals("Anakin Skywalker")));
    }
}