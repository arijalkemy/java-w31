package com.bootcamp.productos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcamp.productos.domain.Producto;
import com.bootcamp.productos.dto.ProductoDto;
import com.bootcamp.productos.exception.BadRequestException;
import com.bootcamp.productos.exception.ProductoNotFoundException;
import com.bootcamp.productos.repository.ProductoRepository;

@Service
public class ProductoService implements IProductoService {
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductoDto> getAllProducts() {
        Iterable<Producto> productos = repository.findAll();
        List<ProductoDto> productosDto = new ArrayList<>();

        for (Producto producto : productos) {
            productosDto.add(ProductoDto.fromEntity(producto));
        }
        if (productosDto.isEmpty()) {
            throw new ProductoNotFoundException("No se encontraron productos.");
        }

        return productosDto;
    }

    @Override
    public String createNewProduct(ProductoDto productoDto) {
        if (productoDto == null) {
            throw new BadRequestException("No se puede crear un producto nulo.");
        }
        Producto producto = productoDto.toProduct();
        Producto guardado = repository.save(producto);
        return guardado.getId();
    }

    @Override
    public ProductoDto updateProduct(String id, ProductoDto productoDto) {
        Producto producto = repository.findById(id).orElse(null);
        if (producto == null) {
            throw new ProductoNotFoundException("No se encontró el producto a actualizar.");
        }

        producto.setNombre(productoDto.getNombre());
        producto.setPrecioCosto(productoDto.getPrecioCosto());
        producto.setPrecioVenta(productoDto.getPrecioVenta());
        producto.setStock(productoDto.getStock());
        producto.setTipo(productoDto.getTipo());

        Producto nuevoProducto = repository.save(producto);
        return ProductoDto.fromEntity(nuevoProducto);
    }

}
