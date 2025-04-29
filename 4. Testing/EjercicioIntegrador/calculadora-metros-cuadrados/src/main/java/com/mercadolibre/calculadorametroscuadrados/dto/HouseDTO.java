package com.mercadolibre.calculadorametroscuadrados.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {
  @NotBlank(message = "El nombre es obligatorio.")
  @Size(min = 3, max = 25, message = "El nombre debe tener entre 3 y 50 caracteres.")
  private String name;

  @NotBlank(message = "La dirección es obligatoria.")
  @Size(min = 3, max = 25, message = "La dirección no debe exceder los 100 caracteres.")
  private String address;

  @NotNull(message = "Debe haber al menos una habitación.")
  @Valid
  private List<RoomDTO> rooms;
}
