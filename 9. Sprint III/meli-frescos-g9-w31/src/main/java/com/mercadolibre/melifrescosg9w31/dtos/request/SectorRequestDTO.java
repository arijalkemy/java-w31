package com.mercadolibre.melifrescosg9w31.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectorRequestDTO {

    @NotNull(message = "Section code cannot be null.")
    @JsonProperty("section_code")
    private Integer sectorCode;

    @NotNull(message = "Warehouse code cannot be null.")
    @JsonProperty("warehouse_code")
    private Integer warehouseCode;
}
