package com.mercadolibre.melifrescosg9w31.dtos.response;

import com.mercadolibre.melifrescosg9w31.dtos.ProductInOrderWithBatchDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductsWithBatchResponse {
    private Long orderId;
    private List<ProductInOrderWithBatchDTO> products;
}
