package com.bootcamp.vehiculos.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleDto {
    private String patente;
    private String marca;
    private String modelo;
    private Date fechaFabricacion;
    private Integer cantidadDeRuedas;

    public static VehicleDto fromEntity(com.bootcamp.vehiculos.model.Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }
        VehicleDto dto = new VehicleDto();
        dto.setPatente(vehicle.getPatente());
        dto.setMarca(vehicle.getMarca());
        dto.setModelo(vehicle.getModelo());
        dto.setFechaFabricacion(vehicle.getFechaFabricacion());
        dto.setCantidadDeRuedas(vehicle.getCantidadDeRuedas());
        return dto;
    }
}