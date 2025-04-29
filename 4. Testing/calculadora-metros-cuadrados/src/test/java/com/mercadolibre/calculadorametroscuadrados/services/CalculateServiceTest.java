package com.mercadolibre.calculadorametroscuadrados.services;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {

    CalculateService calculateService;

    @BeforeEach
    public void setUp(){
        calculateService = new CalculateService();
    }
    @DisplayName("Return price")
    @Test
    public void calculate_shouldReturnArea_WhenHouseIsValid(){
        //Arrange
        RoomDTO comedor = new RoomDTO();
        comedor.setName("Comedor");
        comedor.setWidth(20);
        comedor.setLength(20);

        RoomDTO comedorGigante = new RoomDTO();
        comedorGigante.setName("Comedor gigante");
        comedorGigante.setWidth(30);
        comedorGigante.setLength(30);
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(comedor);
        rooms.add(comedorGigante);
        HouseDTO house = new HouseDTO();
        house.setAddress("Siempreviva 123");
        house.setName("Casa");
        house.setRooms(rooms);
        //Act

        HouseResponseDTO result = calculateService.calculate(house);

        //Asserts
        Assert.isTrue(Integer.valueOf((30 * 30  + 20 * 20) * 800).equals(result.getPrice()));
        Assert.isTrue(Integer.valueOf(30* 30 + 20*20).equals(result.getSquareFeet()));
        assertEquals(Integer.valueOf((30* 30 + 20 * 20) * 800), result.getPrice());
        assertEquals(comedorGigante, result.getBiggest());
    }
}
