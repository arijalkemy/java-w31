package com.mercadolibre.melifrescosg9w31.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductStockResponseDTO {

    @JsonProperty("warehouse_code")
    private Integer warehouseCode;

    @JsonProperty("product_info")
    private List<ProductStockItemResponseDTO> productInfo;
}
