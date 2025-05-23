package com.example.jpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDto implements Serializable {
    private Long id;

    @NotNull(message = "Placa is required")
    @Size(message = "Placa can have up to 6 characters")
    private String placa;

    @NotNull(message = "Marca is required")
    private String marca;

    @NotNull(message = "Model is required")
    private String model;

    @NotNull(message = "Year of manufacture is required")
    @Min(value = 1800, message = "year must be 1800")
    private Integer yearOfManufacture;

    @NotNull(message = "Number of wheels is required")
    @Min(value = 0, message = "Number must be zero or positive")
    private Integer numberOfWheels;

    private List<AccidentDto> accidents;
}
