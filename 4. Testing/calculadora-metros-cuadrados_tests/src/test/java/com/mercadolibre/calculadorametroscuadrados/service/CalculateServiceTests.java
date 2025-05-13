package com.mercadolibre.calculadorametroscuadrados.service;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculateServiceTests {

    private final CalculateService calculateService = new CalculateService();

    @Test
    public void tetsCalculateBiggestRoom(){
        RoomDTO room1 = new RoomDTO("Hab 1", 20, 30);
        RoomDTO room2 = new RoomDTO("Hab 2", 40, 50);
        HouseDTO house = new HouseDTO("Casa 1", "Avenida 123", List.of(room1, room2));

        HouseResponseDTO expectedResponse = new HouseResponseDTO(2600, 2080000, room2);
        HouseResponseDTO serviceResponse = calculateService.calculate(house);

        assertEquals(expectedResponse.getBiggest(), serviceResponse.getBiggest());
    }

    @Test
    public void testNullWidthMustBeZero(){
        RoomDTO room1 = new RoomDTO("Hab 2", null, 50);
        HouseDTO house = new HouseDTO("Casa 1", "Avenida 123", List.of(room1));

        HouseResponseDTO expectedResponse = new HouseResponseDTO(0, 0, room1);
        HouseResponseDTO serviceResponse = calculateService.calculate(house);

        assertEquals(expectedResponse, serviceResponse);
    }

    @Test
    public void testNullLengthMustBeZero(){
        RoomDTO room1 = new RoomDTO("Hab 2", 40, null);
        HouseDTO house = new HouseDTO("Casa 1", "Avenida 123", List.of(room1));

        HouseResponseDTO expectedResponse = new HouseResponseDTO(0, 0, room1);
        HouseResponseDTO serviceResponse = calculateService.calculate(house);

        assertEquals(expectedResponse, serviceResponse);
    }

    @Test
    public void testSquareFeet(){
        RoomDTO room1 = new RoomDTO("Hab 1", 20, 30);
        RoomDTO room2 = new RoomDTO("Hab 2", 40, 50);
        HouseDTO house = new HouseDTO("Casa 1", "Avenida 123", List.of(room1, room2));

        HouseResponseDTO expectedResponse = new HouseResponseDTO(2600, 2080000, room2);
        HouseResponseDTO serviceResponse = calculateService.calculate(house);

        assertEquals(expectedResponse.getSquareFeet(), serviceResponse.getSquareFeet());
    }
}
