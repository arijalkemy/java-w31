package com.mercadolibre.melifrescosg9w31.controller;

import com.mercadolibre.melifrescosg9w31.dtos.ProductDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.PurchaseOrderRequestWrapper;
import com.mercadolibre.melifrescosg9w31.dtos.request.UpdateOrderProductsRequest;
import com.mercadolibre.melifrescosg9w31.dtos.response.OrderProductsResponse;
import com.mercadolibre.melifrescosg9w31.dtos.response.PurchaseOrderErrorResponse;
import com.mercadolibre.melifrescosg9w31.dtos.response.PurchaseOrderResponse;
import com.mercadolibre.melifrescosg9w31.exceptions.StockException;
import com.mercadolibre.melifrescosg9w31.service.IProductService;
import com.mercadolibre.melifrescosg9w31.service.IPurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
@RequiredArgsConstructor
public class CartController {

    private final IProductService productService;
    private final IPurchaseOrderService purchaseOrderService;

    //ENDPOINT 1 y 2
    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> listByCategory(
            @RequestParam(value = "category", required = false) String categoryCode) {

        if (categoryCode == null) {
            return ResponseEntity.ok(productService.getAllProducts());
        } else {
            return ResponseEntity.ok(productService.getProductsByCategory(categoryCode));
        }
    }
    //ENDPOINT 3
    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody PurchaseOrderRequestWrapper requestJson) {
        try {
            PurchaseOrderResponse resp = purchaseOrderService.createOrder(requestJson.getPurchaseOrder());
            return ResponseEntity.status(HttpStatus.CREATED).body(resp);
        } catch (StockException se) {
            PurchaseOrderErrorResponse errResp = new PurchaseOrderErrorResponse();
            errResp.setErrors(se.getErrors());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errResp);
        }
    }
    //ENDPOINT 4
    @GetMapping("/orders/{idOrden}")
    public ResponseEntity<OrderProductsResponse> getProductInOrder(@PathVariable("idOrden") Long idOrden) {
        return ResponseEntity.ok(purchaseOrderService.getOrderProducts(idOrden));
    }

    //ENDPOINT 5
    @PutMapping("/orders/{idOrder}")
    public ResponseEntity<?> updateOrderProducts(
            @PathVariable Long idOrder,
            @RequestBody UpdateOrderProductsRequest req
    ) {
        try {
            return ResponseEntity.ok(purchaseOrderService.updateOrderProducts(idOrder, req));
        }
        catch (StockException se) {
            PurchaseOrderErrorResponse errResp = new PurchaseOrderErrorResponse();
            errResp.setErrors(se.getErrors());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errResp);
        }

    }


}
