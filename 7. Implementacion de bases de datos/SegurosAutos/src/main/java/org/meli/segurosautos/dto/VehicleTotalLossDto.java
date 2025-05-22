package org.meli.segurosautos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class VehicleTotalLossDto {
    private String licensePlate;
    private String brand;
    private String model;
    private Double totalLoss;
}
