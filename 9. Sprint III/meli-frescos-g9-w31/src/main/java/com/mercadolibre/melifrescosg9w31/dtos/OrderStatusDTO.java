package com.mercadolibre.melifrescosg9w31.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderStatusDTO {
    @JsonProperty("status_code")
    private String statusCode;
}
