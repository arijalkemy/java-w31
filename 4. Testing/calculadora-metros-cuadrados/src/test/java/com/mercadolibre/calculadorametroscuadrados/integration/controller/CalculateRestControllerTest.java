package com.mercadolibre.calculadorametroscuadrados.integration.controller;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.util.CustomFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void calculate_shouldReturnThePriceAndSquareFeetHouseResponseDTO() throws Exception {
        // Arrange
        String payloadJson = CustomFactory.getHouseDto();
        HouseResponseDTO response = CustomFactory.getHouseResponseDto();

        // Act & Assert
        this.mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(response.getName()))
                .andExpect(jsonPath("$.biggest.squareFeet").value(response.getBiggest().getSquareFeet()));

    }

    @Test
    public void calculate_shouldReturnBadRequest_whenHouseIsInvalid() throws Exception {
        // Arrange
        String invalidPayload = "";

        // Act & Assert
        this.mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidPayload))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
