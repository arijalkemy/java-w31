package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculate() throws Exception{
        List<RoomDTO> roomDTOList = new ArrayList<>();
        RoomDTO room1 = new RoomDTO("Hab 1", 5, 10);
        RoomDTO room2 = new RoomDTO("Hab 2", 9, 20);
        roomDTOList.add(room1);
        roomDTOList.add(room2);

        HouseDTO house = new HouseDTO("Casa 1", "Address", roomDTOList);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(house);

        HouseResponseDTO response = new HouseResponseDTO(house);
        response.setSquareFeet(230);
        response.setBiggest(room2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson)).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
