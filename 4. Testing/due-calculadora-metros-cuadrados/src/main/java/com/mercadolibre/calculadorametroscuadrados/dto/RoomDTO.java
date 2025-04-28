package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class RoomDTO {
  private String name;
  private Integer width;
  private Integer length;

  public RoomDTO() {
  }

  public RoomDTO(String name, Integer width, Integer length) {
    this.name = name;
    this.width = width;
    this.length = length;
  }

  public Integer getSquareFeet() {
    int result = 0;
    if(this.width != null && this.length != null)
      result = this.width * this.length;
    return result;
  }
}
