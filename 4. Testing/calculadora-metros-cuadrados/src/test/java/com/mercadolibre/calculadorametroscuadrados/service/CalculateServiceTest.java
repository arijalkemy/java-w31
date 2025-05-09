package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import static com.mercadolibre.calculadorametroscuadrados.util.CustomFactory.getHouseDtoObject;
import static com.mercadolibre.calculadorametroscuadrados.util.CustomFactory.getHouseResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculateServiceTest {


    private CalculateService calculateService;


    @BeforeEach
    void setUp() {
        calculateService = new CalculateService();
    }

    @Test
    void Calculate_House_PriceTest() throws IOException {
        // Arrange
        HouseResponseDTO expectedHouse = getHouseResponseDto();
        HouseDTO houseFound = getHouseDtoObject();

        // Act
        HouseResponseDTO houseResponseFound = calculateService.calculate(houseFound);

        // Assert
        assertEquals(expectedHouse.getPrice(), houseResponseFound.getPrice());
    }

    @Test
    void Calculate_Given_Width_And_Length_Biggest_RooomTest() throws IOException {
        // Arrange
        HouseResponseDTO expectedHouse = getHouseResponseDto();
        HouseDTO houseFound = getHouseDtoObject();
        RoomDTO biggestRoom = expectedHouse.getBiggest();
        Integer widthRoomBiggestExpected = biggestRoom.getWidth();
        Integer lengthRoomBiggestExpected = biggestRoom.getLength();

        // Act
        HouseResponseDTO houseResponseFound = calculateService.calculate(houseFound);

        //Assert
        assertEquals(widthRoomBiggestExpected, houseResponseFound.getBiggest().getWidth());
        assertEquals(lengthRoomBiggestExpected, houseResponseFound.getBiggest().getLength());
    }

    @Test
    void Calculate_Square_Feet_By_Room() throws IOException {
        // Arrange
        HouseResponseDTO expectedHouse = getHouseResponseDto();
        HouseDTO houseFound = getHouseDtoObject();
        RoomDTO biggestRoom = expectedHouse.getBiggest();
        Integer squareFeetRoomExpected = biggestRoom.getSquareFeet();

        // Act
        HouseResponseDTO houseResponseFound = calculateService.calculate(houseFound);

        //Assert
        assertEquals(squareFeetRoomExpected, houseResponseFound.getBiggest().getSquareFeet());
    }

}
