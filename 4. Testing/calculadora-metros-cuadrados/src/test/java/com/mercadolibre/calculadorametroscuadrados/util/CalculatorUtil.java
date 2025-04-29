package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.List;

public class CalculatorUtil {
    public static RoomDTO getRoom(String name, int width, int length) {
        return new RoomDTO(name, width, length);
    }

    public static HouseDTO getHouse(List<RoomDTO> rooms) {
        return new HouseDTO("Oficina", "Monroe 800", rooms);
    }
}
