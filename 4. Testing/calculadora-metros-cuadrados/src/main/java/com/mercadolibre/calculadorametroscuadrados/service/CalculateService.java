package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

public class CalculateService {
  public HouseResponseDTO calculate(HouseDTO house) {
    HouseResponseDTO response = new HouseResponseDTO(house);
    // Calcula los metros cuadrados totales y la habitación más grande
    calculateRoomSquareFeet(house, response);

    // Calcula el precio total basado en los metros cuadrados y lo asigna a la respuesta
    response.setPrice(calculatePrice(response.getSquareFeet()));

    return response;
  }

  private void calculateRoomSquareFeet(HouseDTO house, HouseResponseDTO response) {
    Integer totalSquareFeet = 0;
    RoomDTO biggest = null;
    Integer maxRoom = 0;

    for (RoomDTO room : house.getRooms()) {
      // Calcula los metros cuadrados de la habitación actual
      Integer squareFeet = room.getSquareFeet();
      // Suma los metros cuadrados de la habitación al total
      totalSquareFeet += squareFeet;

      // Verifica si la habitación actual es la más grande hasta ahora
      if (biggest == null || squareFeet > maxRoom) {
        biggest = room;
        maxRoom = squareFeet;
      }
    }
    // Asigna los metros cuadrados totales y la habitación más grande al objeto de respuesta
    response.setSquareFeet(totalSquareFeet);
    response.setBiggest(biggest);
  }

  private int calculatePrice(Integer result) {
    return result * 800;
  }
}
