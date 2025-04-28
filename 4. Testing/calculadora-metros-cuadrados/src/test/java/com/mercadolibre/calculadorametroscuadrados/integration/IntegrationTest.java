package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
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
        HouseDTO house = new HouseDTO("Luxury House", "CL 500 # 50", List.of(
                new RoomDTO("Living Room", 10, 10) // 100 sqft
        ));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(house);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Luxury House"))
                .andExpect(jsonPath("$.address").value("CL 500 # 50"))
                .andExpect(jsonPath("$.squareFeet").value(100));
    }

    @Test
    public void calculateHouseWithMultipleRoom() throws Exception {
        HouseDTO house = new HouseDTO("House Blue", "CL 200 # 5", List.of( new RoomDTO("Main", 8,8), new RoomDTO("Hall", 5, 5)));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(house);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("House Blue"))
                .andExpect(jsonPath("$.squareFeet").value(89))
                .andExpect(jsonPath("$.price").value(71200))
                .andExpect(jsonPath("$.biggest.name").value("Main"));

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
        RoomDTO room1 = new RoomDTO("Room A", 5, 5); // 25 sqft
        RoomDTO room2 = new RoomDTO("Room B", 6, 5); // 30 sqft
        HouseDTO house = new HouseDTO("Twin House", "CL 111 # 11", List.of(room1, room2));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(house);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Twin House"))
                .andExpect(jsonPath("$.biggest.name").value("Room B"));
    }

    @Test
    public void calculateRoomsSquareFeet() throws Exception {
        RoomDTO room1 = new RoomDTO("Room A", 5, 5); // 25 sqft
        RoomDTO room2 = new RoomDTO("Room B", 4, 8); // 32 sqft
        RoomDTO room3 = new RoomDTO("Room C", 9, 9); // 81 sqft
        HouseDTO house = new HouseDTO("Twin House", "CL 111 # 11", List.of(room1, room2, room3 ));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(house);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.rooms[0].squareFeet").value(25))
                .andExpect(jsonPath("$.rooms[1].squareFeet").value(32))
                .andExpect(jsonPath("$.rooms[2].squareFeet").value(81));

    }



}
