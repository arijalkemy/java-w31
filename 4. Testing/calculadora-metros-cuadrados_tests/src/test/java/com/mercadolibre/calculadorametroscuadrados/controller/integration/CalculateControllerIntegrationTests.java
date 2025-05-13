package com.mercadolibre.calculadorametroscuadrados.controller.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    private static ObjectWriter writer;

    private RoomDTO room1;
    private RoomDTO room2;


    @BeforeAll
    public static void setUp(){
        writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false).
                writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void setHouse(){
        room1 = new RoomDTO("Hab 1", 20, 30);
        room2 = new RoomDTO("Hab 2", 40, 50);
    }


    @Test
    public void testCalculate() throws Exception {
        HouseDTO payloadDTO = new HouseDTO("casa 1", "Avenida 123", List.of(room1,room2));
        String payloadJson = writer.writeValueAsString(payloadDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testNoHouse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    @Test
    public void testCalculateBiggestRoom() throws Exception {
        HouseDTO payloadDTO = new HouseDTO("casa 1", "Avenida 123", List.of(room1,room2));
        String payloadJson = writer.writeValueAsString(payloadDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print())
                .andExpect(jsonPath("$.biggest.name").value("Hab 2"));
    }


}
