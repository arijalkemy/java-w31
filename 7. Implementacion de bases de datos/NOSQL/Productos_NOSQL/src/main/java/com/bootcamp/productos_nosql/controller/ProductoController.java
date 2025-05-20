package com.bootcamp.productos_nosql.controller;

import com.bootcamp.productos_nosql.model.Producto;
import com.bootcamp.productos_nosql.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    @Autowired
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return service.guardarProducto(producto);
    }
// chequeo en http://localhost:9200/producto/_search?pretty
}
