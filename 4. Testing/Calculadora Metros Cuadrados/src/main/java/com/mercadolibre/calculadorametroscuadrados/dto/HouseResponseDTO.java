package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class HouseResponseDTO extends HouseDTO {
  private Integer squareFeet;
  private Integer price;
  private RoomDTO biggest;

  public HouseResponseDTO(HouseDTO house) {
    super(house.getName(), house.getAddress(), house.getRooms());
  }
}
