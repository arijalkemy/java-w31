package com.mercadolibre.melifrescosg9w31.service;

import com.mercadolibre.melifrescosg9w31.dtos.request.PurchaseOrderRequest;
import com.mercadolibre.melifrescosg9w31.dtos.request.UpdateOrderProductsRequest;
import com.mercadolibre.melifrescosg9w31.dtos.response.OrderProductsResponse;
import com.mercadolibre.melifrescosg9w31.dtos.response.OrderProductsWithBatchResponse;
import com.mercadolibre.melifrescosg9w31.dtos.response.PurchaseOrderResponse;

public interface IPurchaseOrderService {
    PurchaseOrderResponse createOrder(PurchaseOrderRequest request);
    OrderProductsResponse getOrderProducts(Long orderId);
    OrderProductsWithBatchResponse updateOrderProducts(Long orderId, UpdateOrderProductsRequest req);
}
