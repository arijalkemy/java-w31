package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

class CalculateRestControllerTest {
    private final CalculateRestController controller = new CalculateRestController();

    @Test
    void testCalculateReturnsCorrectResponse() {
        RoomDTO room = new RoomDTO();
        room.setName("TestRoom");
        room.setWidth(3);
        room.setLength(4);

        HouseDTO house = new HouseDTO();
        house.setName("TestHouse");
        house.setAddress("FakeAv 123");
        house.setRooms(Collections.singletonList(room));

        HouseResponseDTO response = controller.calculate(house);

        assertThat(response.getSquareFeet()).isEqualTo(12);
        assertThat(response.getPrice()).isEqualTo(9600);
        assertThat(response.getBiggest()).isNotNull();
        assertThat(response.getBiggest().getName()).isEqualTo("TestRoom");
    }

    @Test
    void testCalculateWithEmptyRooms() {
        HouseDTO house = new HouseDTO();
        house.setName("Casa vacía");
        house.setAddress("Calle 1");
        house.setRooms(Collections.emptyList());

        HouseResponseDTO response = controller.calculate(house);

        assertThat(response.getSquareFeet()).isEqualTo(0);
        assertThat(response.getBiggest()).isNull();
        assertThat(response.getPrice()).isEqualTo(0);
    }
}