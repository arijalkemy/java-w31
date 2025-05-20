package com.mercadolibre.empleados.service;

import com.mercadolibre.empleados.domain.Producto;

public interface IProductService {
    void saveProduct(Producto producto);
    void updateProduct(String id, Producto producto);
    Producto getProductById(String id);
}
