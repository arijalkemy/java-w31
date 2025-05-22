package org.meli.segurosautos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClaimDto {
    private Long id;
    private LocalDate claimDate;
    private Double economicLoss;
    private Long vehicleId;
}
