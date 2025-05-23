package com.example.jpa.dto;

import com.example.jpa.model.Vehicle;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehiculoSiniestroDto {
    private Vehicle vehiculo;
    private Double perdidaTotal;
}

