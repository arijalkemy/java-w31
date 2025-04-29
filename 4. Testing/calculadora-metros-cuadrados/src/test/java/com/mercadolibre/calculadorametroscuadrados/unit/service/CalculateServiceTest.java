package com.mercadolibre.calculadorametroscuadrados.unit.service;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculateServiceTest {

        private CalculateService service;
        private HouseDTO barbieHouse;

        @BeforeEach
        void init(){
            service = new CalculateService();
            barbieHouse = new HouseDTO(
                    "La casa de barbie",
                    "barbieland 123",
                    List.of(
                            new RoomDTO("Baño", 130, 150),
                            new RoomDTO("Habitacion", 400, 400)
                    )
            );
        }


    @Test
    public void calculate_shouldReturnAHouseResponseDTO(){
        // Arrange
        HouseResponseDTO response = new HouseResponseDTO(barbieHouse);

        // Act
        HouseResponseDTO responseObtained = service.calculate(barbieHouse);

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
        // Act
        HouseResponseDTO responseObtained = service.calculate(barbieHouse);

        // Assert
        assertNotNull(responseObtained.getBiggest());
        assertEquals("Habitacion", responseObtained.getBiggest().getName());
        assertEquals(400, responseObtained.getBiggest().getWidth());
        assertEquals(400, responseObtained.getBiggest().getLength());
    }
}

