package com.mercadolibre.starwars.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StarWarsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void  getCharactersByDarth_shouldReturnListOfCharacters() throws Exception{
        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/findCharacter/{name}", "Darth"))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Darth Vader"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Darth Maul"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                        .andReturn();
    }
    @Test
    public void  getCharactersByLu_shouldReturnListOfCharacters() throws Exception{
        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/findCharacter/{name}", "Lu"))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Luke Skywalker"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1))
                        .andReturn();
    }
    @Test
    public void  getCharacters_withBadArguments_shouldReturnListOfCharacters() throws Exception{
        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/findCharacter/{name}", "--"))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(0))
                        .andReturn();
    }
}
