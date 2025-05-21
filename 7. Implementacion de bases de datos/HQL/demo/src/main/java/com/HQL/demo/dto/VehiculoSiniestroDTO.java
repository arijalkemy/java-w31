package com.HQL.demo.dto;

import com.HQL.demo.model.Vehiculo;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Data
public class VehiculoSiniestroDTO {
    private Vehiculo vehiculo;
    private Double perdidaTotal;
}
