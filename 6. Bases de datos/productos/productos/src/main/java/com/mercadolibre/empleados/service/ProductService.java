package com.mercadolibre.empleados.service;

import com.mercadolibre.empleados.domain.Producto;
import com.mercadolibre.empleados.repository.IProdutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProdutRepository repository;

    @Override
    public void saveProduct(Producto producto) {
        repository.save(producto);
    }

    @Override
    public void updateProduct(String id, Producto producto) {
    Producto productoObtained = this.getProductById(id);
        productoObtained.setTipo(producto.getTipo());
        productoObtained.setNombre(producto.getNombre());
        productoObtained.setCantidadDisponible(producto.getCantidadDisponible());
        productoObtained.setPrecioDeCosto(producto.getPrecioDeCosto());
        productoObtained.setPrecioDeVenta(producto.getPrecioDeVenta());
        repository.save(productoObtained);
    }

    @Override
    public Producto getProductById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }
}
