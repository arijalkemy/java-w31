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
public class SiniestroDto {
    private Date fecha;
    private Integer perdidaEconomica;
    private Long vehiculoDenunciadoId;

    public static SiniestroDto fromEntity(com.bootcamp.vehiculos.model.Siniestro siniestro) {
        if (siniestro == null) {
            return null;
        }
        SiniestroDto dto = new SiniestroDto();
        dto.setFecha(siniestro.getFecha());
        dto.setPerdidaEconomica(siniestro.getPerdidaEconomica());
        if (siniestro.getVehiculoDenunciado() != null) {
            dto.setVehiculoDenunciadoId(siniestro.getVehiculoDenunciado().getId());
        }
        return dto;
    }
}