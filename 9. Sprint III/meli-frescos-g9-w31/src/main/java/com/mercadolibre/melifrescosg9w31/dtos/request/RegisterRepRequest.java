package com.mercadolibre.melifrescosg9w31.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRepRequest {
    private String username;
    private String password;
    @JsonProperty("warehouse_code")
    private Integer warehouseCode;
}
