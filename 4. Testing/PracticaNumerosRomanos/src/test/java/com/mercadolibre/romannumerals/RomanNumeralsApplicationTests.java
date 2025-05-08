package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RomanNumeralsRestController.class)
class RomanNumeralsRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Devuelve I para 1")
    void shouldReturnIFor1() throws Exception {
        mockMvc.perform(get("/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("I"));
    }

    @Test
    @DisplayName("Devuelve III para 3")
    void shouldReturnIIIFor3() throws Exception {
        mockMvc.perform(get("/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("III"));
    }

    @Test
    @DisplayName("Devuelve V para 5")
    void shouldReturnVFor5() throws Exception {
        mockMvc.perform(get("/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("V"));
    }

    @Test
    @DisplayName("Devuelve VII para 7")
    void shouldReturnVIIFor7() throws Exception {
        mockMvc.perform(get("/7"))
                .andExpect(status().isOk())
                .andExpect(content().string("VII"));
    }

    @Test
    @DisplayName("Devuelve X para 10")
    void shouldReturnXFor10() throws Exception {
        mockMvc.perform(get("/10"))
                .andExpect(status().isOk())
                .andExpect(content().string("X"));
    }

    @Test
    @DisplayName("Devuelve L para 50")
    void shouldReturnLFor50() throws Exception {
        mockMvc.perform(get("/50"))
                .andExpect(status().isOk())
                .andExpect(content().string("L"));
    }


    @Test
    @DisplayName("Devuelve vacío para 0")
    void shouldReturnEmptyForZero() throws Exception {
        mockMvc.perform(get("/0"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    @DisplayName("Devuelve vacío para número negativo")
    void shouldReturnEmptyForNegative() throws Exception {
        mockMvc.perform(get("/-4"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}