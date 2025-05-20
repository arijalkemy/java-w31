package com.mercadolibre.products.service;


import com.mercadolibre.products.model.Product;

import java.util.List;

public interface IProductService {
    Product addProduct(Product product);
    String editProduct(Product product);
    List<Product> findAll();
}
