package com.mercadolibre.melifrescosg9w31.unit.DTO;

import com.mercadolibre.melifrescosg9w31.dtos.OrderStatusDTO;
import com.mercadolibre.melifrescosg9w31.dtos.PurchaseOrderProductDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.UpdateOrderProductsRequest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateOrderProductsRequestTest {
    @Test
    void testAllArgsConstructorAndGetters() {
        OrderStatusDTO status = new OrderStatusDTO();
        status.setStatusCode("CARRITO");
        PurchaseOrderProductDTO prod1 = new PurchaseOrderProductDTO(1, 2);
        PurchaseOrderProductDTO prod2 = new PurchaseOrderProductDTO(2, 3);
        List<PurchaseOrderProductDTO> products = List.of(prod1, prod2);

        UpdateOrderProductsRequest req = new UpdateOrderProductsRequest(status, products);

        assertEquals(status, req.getOrderStatus());
        assertEquals(products, req.getProducts());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        UpdateOrderProductsRequest req = new UpdateOrderProductsRequest();
        OrderStatusDTO status = new OrderStatusDTO();
        status.setStatusCode("CARRITO");
        PurchaseOrderProductDTO prod = new PurchaseOrderProductDTO(1, 2);

        req.setOrderStatus(status);
        req.setProducts(List.of(prod));

        assertEquals(status, req.getOrderStatus());
        assertEquals(1, req.getProducts().size());
        assertEquals(prod, req.getProducts().get(0));
    }
}
