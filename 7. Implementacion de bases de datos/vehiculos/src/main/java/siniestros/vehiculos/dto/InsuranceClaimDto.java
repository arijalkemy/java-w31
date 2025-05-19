package siniestros.vehiculos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceClaimDto {
    private Long id;
    private Date date;
    private Double costOfDamage;
}
