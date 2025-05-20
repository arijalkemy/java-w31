package com.bootcamp.productos.service;

import java.util.List;
import com.bootcamp.productos.dto.ProductoDto;

public interface IProductoService {

    public List<ProductoDto> getAllProducts();

    String createNewProduct(ProductoDto productoDto);

    ProductoDto updateProduct(String id, ProductoDto producto);
}
