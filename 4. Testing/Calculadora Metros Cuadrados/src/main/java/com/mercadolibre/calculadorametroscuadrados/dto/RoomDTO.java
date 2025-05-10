package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class RoomDTO {
  private String name;
  private Integer width;
  private Integer length;
  private Integer squareFeet;

  public Integer getSquareFeet() {
    return (width != null && length != null) ? width * length : 0;
  }

  public RoomDTO(String name, Integer width, Integer length) {
    this.name = name;
    this.width = width;
    this.length = length;
  }
}
