package com.mercadolibre.melifrescosg9w31.mapper;

import com.mercadolibre.melifrescosg9w31.dtos.request.ProductRequestDTO;
import com.mercadolibre.melifrescosg9w31.entity.Product;

public class ProductMapper {

    public static Product toProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setProductType(productRequestDTO.getProductType());
        product.setName(productRequestDTO.getName());
        product.setPrice(productRequestDTO.getPrice());
        product.setDescription(productRequestDTO.getDescription());
        product.setSeller(productRequestDTO.getSeller());
        return product;
    }
}
