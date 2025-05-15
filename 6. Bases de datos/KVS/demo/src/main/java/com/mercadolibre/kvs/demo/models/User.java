package com.mercadolibre.kvs.demo.models;

import lombok.Data;

import java.time.LocalDate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Data
public class User {
    private Long id;
    private String nombre;
    private String apellido;
    @NotNull(message = "El género no puede ser nulo")
    @Pattern(regexp = "^[MF]$", message = "El género debe ser 'M' o 'F'")
    private String genero;
    private LocalDate fechaNacimiento;
}
