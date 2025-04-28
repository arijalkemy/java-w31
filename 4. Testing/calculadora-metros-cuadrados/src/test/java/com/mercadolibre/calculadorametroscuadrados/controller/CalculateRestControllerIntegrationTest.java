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

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest  // cargo contexto
@AutoConfigureMockMvc  //  MockMvc
public class CalculateRestControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc; //simula http
    @Autowired
    private ObjectMapper objectMapper; //convierto a json

    @Test
    void testReturnCalculationForValidHouse() throws Exception {
        // arrange
        HouseDTO house = new HouseDTO();
        house.setName("Casa de Manu");
        house.setAddress("La Plata");

        RoomDTO room1 = new RoomDTO();
        room1.setName("Living");
        room1.setWidth(5);
       room1.setLength(4);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Dormitorio");
        room2.setWidth(3);
        room2.setLength(4);

        house.setRooms(List.of(room1, room2));

        String houseJson = objectMapper.writeValueAsString(house);

        // act y assert
        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(houseJson))
                // status
                .andExpect(status().isOk())
                // content-type
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // data
                .andExpect(jsonPath("$.squareFeet").value(32))
                .andExpect(jsonPath("$.price").value(25600))
                .andExpect(jsonPath("$.biggest.name").value("Living"));
    }

}
