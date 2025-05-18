package com.mercadolibre.romannumerals;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class RomanNumeralsRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
            "0, ''",
            "1, I",
            "3, III",
            "7, VII",
            "10, X",
            "50, L"
    })
    void toRomanSuccesCase(String actual, String expected) throws Exception {
        mockMvc.perform(get("/{number}", actual))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string(expected));
    }

    @Test
    void toRomanDifferentToNumber() throws Exception {
        mockMvc.perform(get("/{number}", "A"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}