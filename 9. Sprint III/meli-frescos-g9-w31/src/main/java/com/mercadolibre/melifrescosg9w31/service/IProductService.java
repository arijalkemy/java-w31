package com.mercadolibre.melifrescosg9w31.service;

import com.mercadolibre.melifrescosg9w31.dtos.ProductBatchDTO;
import com.mercadolibre.melifrescosg9w31.dtos.ProductDTO;
import com.mercadolibre.melifrescosg9w31.dtos.ProductWarehouseDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.ProductRequestDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.UpdateProductRequestDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.ProductStockResponseDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.ResponseMessageDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getProductsByCategory(String categoryCode);
    ProductBatchDTO searchBatchListByProductId(Long idProduct, String order);
    ProductWarehouseDTO searchWarehouseListProductById(Long idProduct);
    ProductStockResponseDTO getProductStockByWarehouse(Long idWarehouse, Integer max);
    ResponseMessageDTO updateProductInWarehouse(Long idProduct, UpdateProductRequestDTO updateProductRequestDTO);
    ResponseMessageDTO addProductInWarehouse(ProductRequestDTO productRequestDTO);

}

