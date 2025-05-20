package com.bootcamp.empleados.dto;

import com.bootcamp.empleados.domain.Empleado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpleadoDto {
    private String id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String provincia;

    public static EmpleadoDto fromEntity(Empleado empleado) {
        if (empleado == null) {
            return null;
        }
        return new EmpleadoDto(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getEdad(),
                empleado.getCiudad(),
                empleado.getProvincia());
    }

    public Empleado toEntity() {
        return new Empleado(
                this.id,
                this.nombre,
                this.apellido,
                this.edad,
                this.ciudad,
                this.provincia);
    }
}
