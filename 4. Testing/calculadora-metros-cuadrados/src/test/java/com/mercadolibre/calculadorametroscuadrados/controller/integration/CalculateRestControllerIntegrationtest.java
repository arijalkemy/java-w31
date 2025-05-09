package com.mercadolibre.calculadorametroscuadrados.controller.integration;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationtest {

    @Autowired
    private MockMvc mockMvc;

    private HouseDTO houseDTO;
    private List<RoomDTO> rooms;
    private RoomDTO room1;
    private RoomDTO room2;
    private HouseResponseDTO houseResponseDTO;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        room1 = new RoomDTO();
        room1.setName("room1");
        room1.setLength(4);
        room1.setWidth(5);
        room2 = new RoomDTO();
        room2.setName("room2");
        room2.setLength(3);
        room2.setWidth(6);
        rooms = List.of(room1, room2);

        houseDTO = new HouseDTO();
        houseDTO.setName("MyHouse");
        houseDTO.setAddress("St1");
        houseDTO.setRooms(rooms);

        houseResponseDTO = new HouseResponseDTO(houseDTO);
        houseResponseDTO.setBiggest(room1);
        houseResponseDTO.setSquareFeet(38);
        houseResponseDTO.setPrice(38 * 800);
    }

    @Test
    public void testCalculate() throws Exception {
        // Arrange
        String houseDtoJson = objectMapper.writeValueAsString(houseDTO);

        // Act & Assert
        mockMvc.perform(post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(houseDtoJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(houseResponseDTO.getName()))
                .andExpect(jsonPath("$.address").value(houseResponseDTO.getAddress()))
                .andExpect(jsonPath("$.rooms.length()").value(2))
                .andExpect(jsonPath("$.price").value(houseResponseDTO.getPrice()))
                .andExpect(jsonPath("$.biggest.name").value(houseResponseDTO.getBiggest().getName()));
    }
}
