package com.bootcamp.productos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.productos.dto.ProductoDto;
import com.bootcamp.productos.service.IProductoService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/products")
public class ProductoController {
    private final IProductoService service;

    public ProductoController(IProductoService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<ProductoDto>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<String> createNewProduct(@RequestBody ProductoDto producto) {
        return new ResponseEntity<>(service.createNewProduct(producto), HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ProductoDto> updateProduct(@PathVariable String id, @RequestBody ProductoDto producto) {
        return new ResponseEntity<>(service.updateProduct(id, producto), HttpStatus.OK);
    }

}
