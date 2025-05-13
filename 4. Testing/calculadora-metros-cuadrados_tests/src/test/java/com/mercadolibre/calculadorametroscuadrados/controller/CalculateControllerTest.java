package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculateControllerTest {

    private final CalculateRestController controller = new CalculateRestController();


    @Test
    public void testCalculateBiggestRoom(){
        RoomDTO room1 = new RoomDTO("Hab 2", 40, 50);
        HouseDTO house = new HouseDTO("Casa 1", "Avenida 123", List.of(room1));

        HouseResponseDTO expectedResponse = new HouseResponseDTO(2000, 1600000, room1);
        HouseResponseDTO serviceResponse = controller.calculate(house);

        assertEquals(expectedResponse.getBiggest(), serviceResponse.getBiggest());
        assertEquals(expectedResponse, serviceResponse);
    }
}
