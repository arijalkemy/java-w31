package com.mercadolibre.melifrescosg9w31.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.melifrescosg9w31.dtos.OrderStatusDTO;
import com.mercadolibre.melifrescosg9w31.dtos.PurchaseOrderProductDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PurchaseOrderRequest {
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("buyer_id")
    private Long buyerId;
    private OrderStatusDTO orderStatus;
    private List<PurchaseOrderProductDTO> products;
}
