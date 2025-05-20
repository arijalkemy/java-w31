package com.bootcamp.productos_nosql.service;

import com.bootcamp.productos_nosql.model.Producto;
import com.bootcamp.productos_nosql.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    private final ProductoRepository repository;

    @Autowired
    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public Producto guardarProducto(Producto producto) {
        return repository.save(producto);
    }

}
