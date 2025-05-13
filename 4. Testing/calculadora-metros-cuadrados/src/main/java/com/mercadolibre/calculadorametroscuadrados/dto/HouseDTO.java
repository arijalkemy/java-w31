package com.mercadolibre.calculadorametroscuadrados.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {
    //@NotBlank
    @Length(min = 1, max = 5)
    private String name;
    @NotBlank
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+\\s\\d+,\\s[A-Za-zÀ-ÿ\\s]+,\\s[A-Za-zÀ-ÿ\\s]+$", message = "Address must follow the format 'Street Name 123, City, Country'")
    private String address;
    private List<RoomDTO> rooms;
}
