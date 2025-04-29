package com.mercadolibre.calculadorametroscuadrados;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;

public class CalculateServiceTests {
    
    @Test
    public void calculate_validDimessions_getAreaOfAHouse(){
        // Arrange
        HouseDTO house = new HouseDTO();
        house.setName("houseTest");
        house.setAddress("Test 123, B Test");
        List<RoomDTO> rooms = new ArrayList<>();

        RoomDTO room1 = new RoomDTO();
        Integer lenght1 = 2;
        room1.setLength(lenght1);
        Integer width1 = 5;
        room1.setWidth(width1);
        room1.setName("Living");
        
        RoomDTO room2 = new RoomDTO();
        Integer lenght2 = 3;
        room2.setLength(lenght2);
        Integer width2 = 4;
        room2.setWidth(width2);
        String nameRoom2 = "Comedor";
        room2.setName(nameRoom2);

        rooms.add(room1);
        rooms.add(room2);
        house.setRooms(rooms);

        // Act
        CalculateService calculateService = new CalculateService();
        HouseResponseDTO houseResponseDto = calculateService.calculate(house);

        // Assert
        assertEquals(houseResponseDto.getSquareFeet(), (lenght1*width1)+(lenght2*width2));
        assertEquals(houseResponseDto.getPrice(), ((lenght1*width1)+(lenght2*width2)) * 800);
        assertEquals(houseResponseDto.getBiggest().getName(), nameRoom2);
    }

    @Test
    public void calculate_invalidDimenssions_getAreaEqualZero(){
        // Arange
        HouseDTO house = new HouseDTO();
        house.setName("houseTest");
        house.setAddress("Test 123, B Test");
        List<RoomDTO> rooms = new ArrayList<>();

        RoomDTO room1 = new RoomDTO();
        room1.setName("Living");

        rooms.add(room1);
        house.setRooms(rooms);

        // Act
        CalculateService calculateService = new CalculateService();
        HouseResponseDTO houseResponseDto = calculateService.calculate(house);

        // Asert
        assertEquals(houseResponseDto.getSquareFeet(), 0);
        
        // Arange
        room1.setWidth(5);
        
        // Act
        houseResponseDto = calculateService.calculate(house);
        
        // Assert
        assertEquals(houseResponseDto.getSquareFeet(), 0);
    }

}
