package com.mercadolibre.empleados.controller;

import com.mercadolibre.empleados.domain.Producto;
import com.mercadolibre.empleados.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService service;
    @PostMapping
    public ResponseEntity<String> saveEmployee(@RequestBody Producto producto) {
        service.saveProduct(producto);
        return ResponseEntity.ok("Producto creado correctamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable String id, @RequestBody Producto producto) {
        service.updateProduct(id, producto);
        return ResponseEntity.ok("Producto actualizado correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getEmployeeById(@PathVariable String id) {
        return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
    }
}
