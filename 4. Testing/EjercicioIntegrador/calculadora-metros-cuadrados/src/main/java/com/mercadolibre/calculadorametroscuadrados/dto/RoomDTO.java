package com.mercadolibre.calculadorametroscuadrados.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
  @NotBlank(message = "El nombre es obligatorio.")
  @Size(min = 3, max = 25, message = "El nombre debe tener entre 3 y 50 caracteres.")
  private String name;

  @NotNull
  @Positive
  private Integer width;

  @NotNull
  @Positive
  private Integer length;

  public Integer getSquareFeet() {
    Integer result = 0;
    if (this.width != null && this.length != null)
      result = this.width * this.length;
    return result;
  }
}
