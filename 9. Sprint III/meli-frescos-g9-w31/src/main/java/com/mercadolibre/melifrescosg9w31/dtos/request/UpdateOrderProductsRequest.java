package com.mercadolibre.melifrescosg9w31.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.melifrescosg9w31.dtos.OrderStatusDTO;
import com.mercadolibre.melifrescosg9w31.dtos.PurchaseOrderProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderProductsRequest {
    @JsonProperty("order_status")
    private OrderStatusDTO orderStatus;
    private List<PurchaseOrderProductDTO> products;
}
