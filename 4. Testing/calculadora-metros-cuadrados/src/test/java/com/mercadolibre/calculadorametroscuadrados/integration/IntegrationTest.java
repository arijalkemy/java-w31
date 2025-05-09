package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.util.CustomFactory;
import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculateOneRoom() throws Exception {
        String json = CustomFactory.getHouseDto();
        HouseResponseDTO response = CustomFactory.getHouseResponseDto();
        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(response.getName()))
                .andExpect(jsonPath("$.address").value(response.getAddress()))
                .andExpect(jsonPath("$.squareFeet").value(response.getSquareFeet()));
    }

    @Test
    public void calculateHouseWithMultipleRoom() throws Exception {
        String json = CustomFactory.getHouseDto();
        HouseResponseDTO response = CustomFactory.getHouseResponseDto();
        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(response.getName()))
                .andExpect(jsonPath("$.squareFeet").value(response.getSquareFeet()))
                .andExpect(jsonPath("$.price").value(response.getPrice()))
                .andExpect(jsonPath("$.biggest.name").value(response.getBiggest().getName()));

    }

    @Test
    public void calculateHousePrice() throws Exception {
        HouseDTO house = new HouseDTO("Luxury House", "CL 500 # 50", List.of(
                new RoomDTO("Living Room", 10, 10) // 100 sqft
        ));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(house);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate").contentType(MediaType.APPLICATION_JSON)
                .content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Luxury House"))
                .andExpect(jsonPath("$.price").value(80000));
    }

    @Test
    public void calculateBiggestRoom() throws Exception {
        String json = CustomFactory.getHouseDto();
        HouseResponseDTO response = CustomFactory.getHouseResponseDto();
        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(response.getName()))
                .andExpect(jsonPath("$.biggest.name").value(response.getBiggest().getName()));
    }

    @Test
    public void calculateRoomsSquareFeet() throws Exception {
        String json = CustomFactory.getHouseDto();
        HouseResponseDTO response = CustomFactory.getHouseResponseDto();
        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.rooms[0].squareFeet").value(response.getRooms().get(0).getSquareFeet()))
                .andExpect(jsonPath("$.rooms[1].squareFeet").value(response.getRooms().get(1).getSquareFeet()));
    }
}
