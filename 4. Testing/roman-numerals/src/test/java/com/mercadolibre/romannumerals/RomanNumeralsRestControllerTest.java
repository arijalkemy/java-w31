package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RomanNumeralsRestController.class) //  levanta el contexto de ese controlador
class RomanNumeralsRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // convertir 1 a I
    @Test
    void testConvert1() throws Exception {
        mockMvc.perform(get("/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("I"));
    }

    // convertir 3 a III
    @Test
    void testConvert3() throws Exception {
        mockMvc.perform(get("/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("III"));
    }

    // convertir 5 a V
    @Test
    void testConvert5() throws Exception {
        mockMvc.perform(get("/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("V"));
    }

    // convertir 7 a VII
    @Test
    void testConvert7() throws Exception {
        mockMvc.perform(get("/7"))
                .andExpect(status().isOk())
                .andExpect(content().string("VII"));
    }

    // convertir 10 a X
    @Test
    void testConvert10() throws Exception {
        mockMvc.perform(get("/10"))
                .andExpect(status().isOk())
                .andExpect(content().string("X"));
    }

    // convertir 50 a L
    @Test
    void testConvert50() throws Exception {
        mockMvc.perform(get("/50"))
                .andExpect(status().isOk())
                .andExpect(content().string("L"));
    }
}
