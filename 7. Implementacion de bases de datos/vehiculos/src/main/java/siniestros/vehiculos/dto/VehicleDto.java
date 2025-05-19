package siniestros.vehiculos.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siniestros.vehiculos.model.InsuranceClaim;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private Long id;
    private String licensePlate;
    private String brand;
    private String model;
    private Integer yearOfManufacture;
    private Integer wheels;
    private Set<InsuranceClaimDto> claims;
}
