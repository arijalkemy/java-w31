package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.Comparator;

public class CalculateService {
  
    public HouseResponseDTO calculate(HouseDTO house) {
        HouseResponseDTO response = new HouseResponseDTO(house);
        calculateRoomSquareFeet(house, response);
        response.setPrice(calculatePrice(response.getSquareFeet()));
        return response;
    }

    private void calculateRoomSquareFeet(HouseDTO house, HouseResponseDTO response) {
        int totalSquareFeet = house.getRooms().stream()
                .mapToInt(RoomDTO::getSquareFeet)
                .sum();

        RoomDTO biggest = house.getRooms().stream()
                .max(Comparator.comparingInt(RoomDTO::getSquareFeet))
                .orElse(null);

        response.setSquareFeet(totalSquareFeet);
        response.setBiggest(biggest);
    }

    private int calculatePrice(Integer result) {
        return result * 800;
    }
}
