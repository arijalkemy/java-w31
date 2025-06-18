package com.mercadolibre.melifrescosg9w31.dtos.response;

import com.mercadolibre.melifrescosg9w31.dtos.ProductInOrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductsResponse {
    private Long orderId;
    private List<ProductInOrderDTO> products;
}
