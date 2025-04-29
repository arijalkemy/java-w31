package com.mercadolibre.calculadorametroscuadrados.integracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateIntegracionTest {

    HouseDTO house = new HouseDTO();
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        RoomDTO room1 = new RoomDTO();
        room1.setName("Cocina");
        room1.setLength(7);
        room1.setWidth(5);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Habitacion");
        room2.setLength(3);
        room2.setWidth(4);

        house.setName("Casa");
        house.setAddress("Libertador 123");
        house.setRooms(List.of(room1, room2));
    }

    @Test
    void testHappyPath() throws Exception {
        mockMvc.perform(post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(47))
                .andExpect(jsonPath("$.name").value(house.getName()))
                .andExpect(jsonPath("$.biggest.squareFeet").value(35));
    }

    @Test
    void testBadRequest() throws Exception {
        mockMvc.perform(post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("\"Hola\""))
                .andExpect(status().isBadRequest());
    }

}
