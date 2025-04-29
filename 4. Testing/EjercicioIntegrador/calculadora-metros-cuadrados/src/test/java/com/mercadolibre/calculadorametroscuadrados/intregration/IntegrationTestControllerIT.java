package com.mercadolibre.calculadorametroscuadrados.intregration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.utils.Util;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTestControllerIT {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @Test
    void calculateTest() throws Exception {
        HouseDTO house = Util.createHouse();
        String houseJson = writer.writeValueAsString(house);
        HouseResponseDTO expectedResponse = new HouseResponseDTO(41, 32800, house.getRooms().get(0));

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType("application/json")
                .content(houseJson))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.squareFeet").value(expectedResponse.getSquareFeet()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(expectedResponse.getPrice()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms.length()").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].name").value("Sala"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[1].name").value("Cocina"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[2].name").value("Dormitorio"));
    }

    @Test
    void calculateTestInvalidArguments() throws Exception {
        HouseDTO invalidHouse = Util.createInvalidHouse();
        String invalidHouseJson = writer.writeValueAsString(invalidHouse);

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType("application/json")
                .content(invalidHouseJson))
                .andExpect(status().isBadRequest())
                .andExpect(
                        result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));
    }

    @Test
    void calculateTestVoidArguments() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType("application/json")
                .content(""))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(
                        result.getResolvedException() instanceof HttpMessageNotReadableException));
    }
}
