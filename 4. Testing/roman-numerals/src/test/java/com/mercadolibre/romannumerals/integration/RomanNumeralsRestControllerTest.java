package com.mercadolibre.romannumerals.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class RomanNumeralsRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @ParameterizedTest
    @CsvSource({
            "1,I",
            "3,III",
            "5,V",
            "7,VII",
            "10,X",
            "50,L"
    })

    // Método helper para evitar repetición
    void performTest(Integer inputNumber, String expectedRoman) throws Exception {
        mockMvc.perform(get("/{number}", inputNumber))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN_VALUE))
                .andExpect(content().string(expectedRoman));
    }
}
