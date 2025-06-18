package com.mercadolibre.melifrescosg9w31.controller;

import com.mercadolibre.melifrescosg9w31.dtos.ProductBatchDTO;
import com.mercadolibre.melifrescosg9w31.dtos.ProductWarehouseDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.ProductRequestDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.UpdateProductRequestDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.ProductStockResponseDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.ResponseMessageDTO;
import com.mercadolibre.melifrescosg9w31.service.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/fresh-products/")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping("{idProduct}/batch/list")
    ResponseEntity<ProductBatchDTO> getBatchListByProductId(@PathVariable Long idProduct,
                                                            @RequestParam(required = false) String order) {
        return new ResponseEntity<>(productService.searchBatchListByProductId(idProduct, order), HttpStatus.OK);
    }

    @GetMapping("{idProduct}/warehouse/list")
    ResponseEntity<ProductWarehouseDTO> getWarehouseListByProductId(@PathVariable Long idProduct) {
        return new ResponseEntity<>(productService.searchWarehouseListProductById(idProduct), HttpStatus.OK);
    }

    @GetMapping("{idWarehouse}/list")
    ResponseEntity<ProductStockResponseDTO> getProductStockByWarehouse(@PathVariable Long idWarehouse, @RequestParam(required = false) Integer max) {
        return new ResponseEntity<>(productService.getProductStockByWarehouse(idWarehouse, max), HttpStatus.OK);
    }

    @PostMapping("products/add")
    ResponseEntity<ResponseMessageDTO> postProductByIdInWarehouse(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        return new ResponseEntity<>(productService.addProductInWarehouse(productRequestDTO), HttpStatus.OK);
    }
    @PutMapping("products/{idProduct}")
    ResponseEntity<ResponseMessageDTO> putProductByIdInWarehouse(@PathVariable Long idProduct, @Valid @RequestBody UpdateProductRequestDTO updateProductRequestDTO) {
        return new ResponseEntity<>(productService.updateProductInWarehouse(idProduct, updateProductRequestDTO), HttpStatus.CREATED);
    }

}


