package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CalculateServiceTest {

    @Autowired
    private CalculateService calculateService;

    @Test
    public void testCalculate() {
        // Arrange
        List<RoomDTO> roomDTOList = new ArrayList<>();
        RoomDTO room1 = new RoomDTO("Hab 1", 5, 10);
        RoomDTO room2 = new RoomDTO("Hab 2", 9, 20);
        roomDTOList.add(room1);
        roomDTOList.add(room2);

        HouseDTO house = new HouseDTO("Casa 1", "Address", roomDTOList);

        HouseResponseDTO response = new HouseResponseDTO(house);
        response.setSquareFeet(230);
        response.setBiggest(room2);

        // Act
        HouseResponseDTO houseResponse = calculateService.calculate(house);

        // Assert
        Assertions.assertEquals(response.getSquareFeet(), houseResponse.getSquareFeet());
        Assertions.assertEquals(response.getBiggest(), houseResponse.getBiggest());
    }
}
