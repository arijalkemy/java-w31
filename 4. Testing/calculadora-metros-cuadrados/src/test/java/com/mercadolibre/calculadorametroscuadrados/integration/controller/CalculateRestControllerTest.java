package com.mercadolibre.calculadorametroscuadrados.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void calculate_shouldReturnThePriceAndSquareFeetHouseResponseDTO() throws Exception {
        // Arrange
        HouseDTO house = new HouseDTO("La casa de barbie", "barbieland 123",
                List.of(new RoomDTO("Baño", 130, 150),
                        new RoomDTO("Habitacion", 400, 400)));

        String payloadJson = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter()
                .writeValueAsString(house);
        // Act & Assert
        this.mockMvc.perform(post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(143600000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.squareFeet").value(179500))
                .andReturn();
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
