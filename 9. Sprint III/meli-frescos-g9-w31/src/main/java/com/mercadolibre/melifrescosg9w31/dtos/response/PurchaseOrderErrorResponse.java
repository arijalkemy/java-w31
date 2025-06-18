package com.mercadolibre.melifrescosg9w31.dtos.response;

import com.mercadolibre.melifrescosg9w31.dtos.ProductStockError;
import lombok.Data;

import java.util.List;
@Data
public class PurchaseOrderErrorResponse {
    private List<ProductStockError> errors;
}
