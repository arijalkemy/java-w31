package com.mercadolibre.calculadorametroscuadrados.unit.service;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculateServiceTest {

    private final CalculateService service = new CalculateService();

    @Test
    public void calculate_shouldReturnAHouseResponseDTO(){
        // Arrange
        HouseDTO house = new HouseDTO("La casa de barbie", "barbieland 123",
                                        List.of(new RoomDTO("Baño", 130, 150),
                                                 new RoomDTO("Habitacion", 400, 400)));

        HouseResponseDTO response = new HouseResponseDTO(house);

        // Act
        HouseResponseDTO responseObtained = service.calculate(house);

        // Assert
        assertEquals("La casa de barbie", responseObtained.getName());
        assertEquals("barbieland 123", responseObtained.getAddress());
        assertEquals(179500, responseObtained.getSquareFeet());
        assertEquals("Habitacion", responseObtained.getBiggest().getName());
        assertEquals(143600000, responseObtained.getPrice());
    }

    @Test
    public void calculate_shouldHandleEmptyRooms() {
        // Arrange
        HouseDTO house = new HouseDTO("Casa vacía", "Ahora 123", List.of());

        // Act
        HouseResponseDTO responseObtained = service.calculate(house);

        // Assert
        assertEquals("Casa vacía", responseObtained.getName());
        assertEquals(0, responseObtained.getSquareFeet());
        assertNull(responseObtained.getBiggest());
        assertEquals(0, responseObtained.getPrice());
    }

    @Test
    public void calculate_shouldReturnBiggestRoomBasedOnArea() {
        // Arrange
        HouseDTO house = new HouseDTO("Casa test", "Calle Falsa 123",
                List.of(
                        new RoomDTO("Cocina", 5, 5),       // Área = 25
                        new RoomDTO("Sala", 10, 8),         // Área = 80
                        new RoomDTO("Baño", 3, 4)           // Área = 12
                )
        );

        // Act
        HouseResponseDTO responseObtained = service.calculate(house);

        // Assert
        assertNotNull(responseObtained.getBiggest());
        assertEquals("Sala", responseObtained.getBiggest().getName());
        assertEquals(10, responseObtained.getBiggest().getWidth());
        assertEquals(8, responseObtained.getBiggest().getLength());
    }
}

