package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CalculateServiceTest {

    private CalculateService service;

    @BeforeEach
    void setUp() {
        service = new CalculateService();
    }

    @Test
    void testCalculatePrice() {
        //Arrange
        HouseDTO house = new HouseDTO();

        RoomDTO room1 = new RoomDTO();
        room1.setName("Cocina");
        room1.setLength(7);
        room1.setWidth(5);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Habitacion");
        room2.setLength(3);
        room2.setWidth(4);

        house.setName("Casa");
        house.setAddress("Libertador 123");
        house.setRooms(List.of(room1, room2));

        //Act
        HouseResponseDTO houseResponse = service.calculate(house);

        //Assert
        assertEquals(37600, houseResponse.getPrice());
    }

    @Test
    void testBiggestRoom() {
        //Arrange
        HouseDTO house = new HouseDTO();

        RoomDTO room1 = new RoomDTO();
        room1.setName("Cocina");
        room1.setLength(7);
        room1.setWidth(5);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Habitacion");
        room2.setLength(3);
        room2.setWidth(4);

        house.setName("Casa");
        house.setAddress("Libertador 123");
        house.setRooms(List.of(room1, room2));

        //Act
        HouseResponseDTO houseResponse = service.calculate(house);

        //Assert
        assertEquals(room1, houseResponse.getBiggest());
    }

    @Test
    void testSquareFeet() {
        //Arrange
        HouseDTO house = new HouseDTO();

        RoomDTO room1 = new RoomDTO();
        room1.setName("Cocina");
        room1.setLength(7);
        room1.setWidth(5);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Habitacion");
        room2.setLength(3);
        room2.setWidth(4);

        house.setName("Casa");
        house.setAddress("Libertador 123");
        house.setRooms(List.of(room1, room2));

        // Act
        int squareFeetRoom1 = room1.getSquareFeet();
        int squareFeetRoom2 = room2.getSquareFeet();

        // Assert
        assertEquals(35, squareFeetRoom1);
        assertEquals(12, squareFeetRoom2);

    }



}