package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RomanNumeralsRestController.class)
@ExtendWith(SpringExtension.class)
public class RomanNumeralsRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testConvert1() throws Exception {
        // Arrange: No se necesita datos especiales

        // Act & Assert
        mockMvc.perform(get("/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("I"));
    }

    @Test
    public void testConvert3() throws Exception {
        mockMvc.perform(get("/3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("III"));
    }

    @Test
    public void testConvert5() throws Exception {
        mockMvc.perform(get("/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("V"));
    }

    @Test
    public void testConvert7() throws Exception {
        mockMvc.perform(get("/7")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("VII"));
    }

    @Test
    public void testConvert10() throws Exception {
        mockMvc.perform(get("/10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("X"));
    }

    @Test
    public void testConvert50() throws Exception {
        mockMvc.perform(get("/50")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("L"));
    }
}
