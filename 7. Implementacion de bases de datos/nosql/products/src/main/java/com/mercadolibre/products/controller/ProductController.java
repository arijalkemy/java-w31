package com.mercadolibre.products.controller;

import com.mercadolibre.products.model.Product;
import com.mercadolibre.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/product/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }

    @PutMapping("/product/edit")
    public ResponseEntity<String> editProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.editProduct(product), HttpStatus.OK);
    }
}
