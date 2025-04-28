package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class HouseResponseDTO extends HouseDTO {
  private Integer squareFeet;
  private Integer price;
  private RoomDTO biggest;


  public HouseResponseDTO(HouseDTO house) {
    this.setName(house.getName());
    this.setAddress(house.getAddress());
    this.setRooms(house.getRooms());
  }
}
