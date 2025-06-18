package com.mercadolibre.melifrescosg9w31.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SectionDTO {
    @JsonProperty("section_code")
    private Integer code;
    private Integer warehouseCode;
}
