package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CalculateService calculateService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void givenHouse_whenCalculate_thenCalculatesProperties() throws Exception {
        // Arrange - Given
        RoomDTO room1 = new RoomDTO("Room1", 10, 10);
        RoomDTO room2 = new RoomDTO("Room2", 15, 10);
        HouseDTO housePayload = new HouseDTO("House1", "St. Patrick St. 18",
                List.of(room1, room2));
        int squareFeet = (room1.getLength() * room1.getWidth()) + (room2.getLength() * room2.getWidth());
        String housePayloadJson = objectMapper.writeValueAsString(housePayload);

        // Act - When & Assert - Then
        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(housePayloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.squareFeet").value(squareFeet))
                .andExpect(jsonPath("$.price").value(squareFeet*800))
                .andExpect(jsonPath("$.name").value(housePayload.getName()));
    }
}
