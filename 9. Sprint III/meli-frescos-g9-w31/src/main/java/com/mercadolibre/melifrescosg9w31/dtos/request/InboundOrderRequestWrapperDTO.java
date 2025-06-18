package com.mercadolibre.melifrescosg9w31.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InboundOrderRequestWrapperDTO {
    @NotNull(message = "The inbound order object cannot be null.")
    @Valid
    @JsonProperty("inbound_order")
    private InboundOrderRequest inboundOrder;
}