package com.mercadolibre.melifrescosg9w31.service;

import com.mercadolibre.melifrescosg9w31.dtos.ProductBatchDTO;
import com.mercadolibre.melifrescosg9w31.dtos.ProductDTO;
import com.mercadolibre.melifrescosg9w31.dtos.ProductWarehouseDTO;
import com.mercadolibre.melifrescosg9w31.dtos.WarehouseDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.ProductRequestDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.UpdateProductRequestDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.ProductStockItemResponseDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.ProductStockResponseDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.ResponseMessageDTO;
import com.mercadolibre.melifrescosg9w31.entity.Batch;
import com.mercadolibre.melifrescosg9w31.entity.Product;
import com.mercadolibre.melifrescosg9w31.entity.Sector;
import com.mercadolibre.melifrescosg9w31.entity.Warehouse;
import com.mercadolibre.melifrescosg9w31.exceptions.AlreadyExistsException;
import com.mercadolibre.melifrescosg9w31.exceptions.BadRequestException;
import com.mercadolibre.melifrescosg9w31.exceptions.NotFoundException;
import com.mercadolibre.melifrescosg9w31.mapper.ProductBatchMapper;
import com.mercadolibre.melifrescosg9w31.mapper.ProductMapper;
import com.mercadolibre.melifrescosg9w31.repository.IBatchRepository;
import com.mercadolibre.melifrescosg9w31.repository.IProductRepository;
import com.mercadolibre.melifrescosg9w31.repository.ISectorRepository;
import com.mercadolibre.melifrescosg9w31.repository.IWarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final IBatchRepository batchRepository;
    private final IWarehouseRepository warehouseRepository;
    private final ISectorRepository sectorRepository;
    private final IProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(p -> {
            return new ProductDTO(
                    p.getId(),
                    p.getName(),
                    p.getDescription(),
                    p.getPrice(),
                    p.getProductType().getName(),
                    p.getSeller().getName()
            );
        }).collect(Collectors.toList());
    }

    private ProductDTO toDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getProductType().getName(),
                product.getSeller().getName()
        );
    }


    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getProductsByCategory(String categoryCode) {
        List<Product> products = productRepository.findByProductTypeCategory(categoryCode.toUpperCase());

        if (products.isEmpty()) {
            throw new NotFoundException("No products were found for the category: " + categoryCode + ".");
        }

        return products.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductBatchDTO searchBatchListByProductId(Long idProduct, String order) {
        List<Batch> batchesByProductId;
        if (Objects.isNull(order)) {
            batchesByProductId = batchRepository.findBatchByProductId(idProduct);
        } else {
            switch (order) {
                case "L" -> batchesByProductId = batchRepository.findBatchByProductIdOrderByBatchNumber(idProduct);
                case "C" -> batchesByProductId = batchRepository.findBatchByProductIdOrderByActualQuantity(idProduct);
                case "F" -> batchesByProductId = batchRepository.findBatchByProductIdOrderByDueDate(idProduct);
                default -> throw new BadRequestException("Order not valid.");
            }
        }
        if (batchesByProductId.isEmpty()) {
            throw new NotFoundException("Product with id " + idProduct + " not found or has no batches.");
        }
        return ProductBatchMapper.toProductBatchStockDTO(batchesByProductId, idProduct);
    }

    @Override
    public ProductWarehouseDTO searchWarehouseListProductById(Long idProduct) {
        List<WarehouseDTO> warehouses = Optional.ofNullable(batchRepository.findTotalQuantityInWarehouseByProductId(idProduct))
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new NotFoundException("Product with id " + idProduct + " not found or has no warehouses."));
        return new ProductWarehouseDTO(idProduct, warehouses);
    }

    @Override
    public ProductStockResponseDTO getProductStockByWarehouse(Long idWarehouse, Integer max) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(idWarehouse);
        if (warehouse.isEmpty()) {
            throw new NotFoundException("Warehouse with id " + idWarehouse + " not found.");
        } else {
            List<Sector> sectors = sectorRepository.findByWarehouseId(idWarehouse);

            List<Batch> batches = batchRepository.findBySectorIds(sectors.stream().map(Sector::getId).toList());

            Map<Long, ProductStockItemResponseDTO> stockPorProducto = new HashMap<>();

            batches.forEach(b -> stockPorProducto.put(b.getProduct().getId(),
                    new ProductStockItemResponseDTO(
                            b.getProduct().getId(),
                            b.getProduct().getName(),
                            b.getActualQuantity() + (stockPorProducto.containsKey(b.getProduct().getId()) ?
                                    stockPorProducto.get(b.getProduct().getId()).getCurrentStock() : 0))));

            if (Objects.isNull(max)) {
                return new ProductStockResponseDTO(
                        warehouse.get().getWarehouseCode(),
                        stockPorProducto.values().stream()
                                .sorted(Comparator.comparing(ProductStockItemResponseDTO::getCurrentStock)) // Sort here
                                .toList()
                );
            } else {
                return new ProductStockResponseDTO(
                        warehouse.get().getWarehouseCode(),
                        stockPorProducto.values().stream()
                                .filter(psir -> psir.getCurrentStock() < max)
                                .sorted(Comparator.comparing(ProductStockItemResponseDTO::getCurrentStock)) // Sort here
                                .toList()
                );
            }
        }
    }

    @Override
    public ResponseMessageDTO updateProductInWarehouse(Long idProduct, UpdateProductRequestDTO updateProductRequestDTO) {
        Product existingProduct = productRepository.findById(idProduct).orElseThrow(
                () -> new NotFoundException("The product with id " + idProduct + " not found.")
        );
        if (updateProductRequestDTO.getProductName() != null) {
            existingProduct.setName(updateProductRequestDTO.getProductName());
        }
        if (updateProductRequestDTO.getProductDescription() != null) {
            existingProduct.setDescription(updateProductRequestDTO.getProductDescription());
        }
        if (updateProductRequestDTO.getProductPrice() != null) {
            existingProduct.setPrice(updateProductRequestDTO.getProductPrice());
        }
        productRepository.save(existingProduct);

        return new ResponseMessageDTO("Product updated successfully.");
    }

    @Override
    public ResponseMessageDTO addProductInWarehouse(ProductRequestDTO productRequestDTO) {
        if (productRepository.findByName(productRequestDTO.getName()).isPresent()) {
            throw new AlreadyExistsException("Product with name " + productRequestDTO.getName() + " already exists.");
        }
        Product newProduct = ProductMapper.toProduct(productRequestDTO);
        productRepository.save(newProduct);
        return new ResponseMessageDTO("Product added successfully.");
    }

}





