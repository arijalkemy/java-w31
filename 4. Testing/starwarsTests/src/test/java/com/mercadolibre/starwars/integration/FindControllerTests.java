package com.mercadolibre.starwars.integration;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.unittest.utils.SetTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTests {

    @Autowired
    MockMvc mockMvc;
    SetTests set = new SetTests();

    @Test
    public void testFindCharacters() throws Exception {
        String query = "Darth";
        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Darth Vader"))
                .andExpect(jsonPath("$[1].name").value("Darth Maul"));
    }

    @Test
    public void testEmptyList() throws Exception{
        String query = "Doe";
        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(0));
    }
}
