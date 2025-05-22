package org.meli.segurosautos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class VehicleDto {
    private Long id;
    private String licensePlate;
    private String brand;
    private String model;
    private Integer manufactureYear;
    private Integer numberOfWheels;
    private List<ClaimDto> claims;
}
