package com.bootcamp.joyerialasperlas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.bootcamp.joyerialasperlas.model.Joya;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class JoyaDto implements Serializable {
    @Positive
    private Long id;

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @NotNull(message = "El material no puede ser nulo")
    @Size(min = 2, max = 20, message = "El material debe tener entre 2 y 20 caracteres")
    private String material;

    @NotNull(message = "El peso no puede ser nulo")
    @PositiveOrZero(message = "El peso debe ser mayor o igual a cero")
    private Double peso;

    @NotNull(message = "La particularidad no puede ser nula")
    @Size(min = 2, max = 100, message = "La particularidad debe tener entre 2 y 100 caracteres")
    private String particularidad;
    
    private Boolean poseePiedra;
    private Boolean ventaONo;

    public static JoyaDto joyaToDto(Joya joya) {
        return new JoyaDto(
            joya.getId(),
            joya.getNombre(),
            joya.getMaterial(),
            joya.getPeso(),
            joya.getParticularidad(),
            joya.getPoseePiedra(),
            joya.getVentaONo()
        );
    }
}
