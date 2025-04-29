package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;


@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCalculate_ReturnsCorrectResponse() throws Exception {
        // Arrange
        RoomDTO room1 = new RoomDTO();
        room1.setName("Living Room");
        room1.setWidth(5);
        room1.setLength(4);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Bedroom");
        room2.setWidth(3);
        room2.setLength(3);

        HouseDTO house = new HouseDTO();
        house.setName("Test House");
        house.setRooms(Arrays.asList(room1, room2));

        // Act & Assert
        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(29))
                .andExpect(jsonPath("$.price").value(23200))
                .andExpect(jsonPath("$.biggest.name").value("Living Room"));
    }


}
