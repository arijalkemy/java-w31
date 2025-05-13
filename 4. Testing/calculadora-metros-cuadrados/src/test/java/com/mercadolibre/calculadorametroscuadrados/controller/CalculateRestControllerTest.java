package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.mercadolibre.calculadorametroscuadrados.util.CalculatorUtil.getHouse;
import static com.mercadolibre.calculadorametroscuadrados.util.CalculatorUtil.getRoom;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class CalculateRestControllerTest {
    private static ObjectWriter objectWriter;
    @Autowired
    private MockMvc mockMvc;
    private List<RoomDTO> rooms;

    @BeforeEach
    void setUp() {
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        rooms = List.of(
                getRoom("Espacio abierto", 5, 5),
                getRoom("Cocina", 3, 3),
                getRoom("Baño", 2, 1)
        );
    }

    //Testeamos el dto
    @Test
    void calculateHouseBrokenDto() throws Exception {
        HouseDTO house = getHouse(List.of(
                getRoom("Espacio abierto", 5, 5)
        ));

        house.setName("");
        house.setAddress("Monroe 800");

        performPost(house)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$", containsInAnyOrder(
                        "name: must not be blank",
                        "name: length must be between 3 and 20",
                        "address: Address must follow the format 'Street Name 123, City, Country'"
                )));
    }

    @Test
    void calculateHouseWithOneRoom() throws Exception {
        HouseDTO house = getHouse(List.of(
                getRoom("Espacio abierto", 3, 3)
        ));

        performPost(house)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(9));
    }

    @Test
    void calculateHouseWithMultipleRoom() throws Exception {
        HouseDTO house = getHouse(rooms);

        performPost(house)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(36));
    }

    @Test
    void calculateHousePrice() throws Exception {
        HouseDTO house = getHouse(rooms);

        performPost(house)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(28800));
    }

    @Test
    void calculateBiggestRoom() throws Exception {
        HouseDTO house = getHouse(rooms);

        performPost(house)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.biggest.name").value("Espacio abierto"));
    }

    @Test
    void calculateRoomsSquareFeet() throws Exception {
        HouseDTO house = getHouse(rooms);

        performPost(house)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rooms[0].squareFeet").value(25))
                .andExpect(jsonPath("$.rooms[1].squareFeet").value(9))
                .andExpect(jsonPath("$.rooms[2].squareFeet").value(2));
    }


    private ResultActions performPost(HouseDTO house) throws Exception {
        return mockMvc.perform(
                post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(house))
        ).andDo(print());
    }
}
