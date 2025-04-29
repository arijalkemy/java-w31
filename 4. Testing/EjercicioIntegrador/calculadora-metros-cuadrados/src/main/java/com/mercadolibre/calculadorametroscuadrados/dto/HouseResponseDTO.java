package com.mercadolibre.calculadorametroscuadrados.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseResponseDTO extends HouseDTO {
  @NotNull
  @Positive
  private Integer squareFeet;

  @NotNull
  @Positive
  private Integer price;

  @NotNull
  private RoomDTO biggest;

  public HouseResponseDTO(HouseDTO house) {
    this.setName(house.getName());
    this.setAddress(house.getAddress());
    this.setRooms(house.getRooms());
  }
}
