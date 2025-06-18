package com.mercadolibre.melifrescosg9w31.service.validator;

import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import com.mercadolibre.melifrescosg9w31.entity.*;
import com.mercadolibre.melifrescosg9w31.exceptions.AlreadyExistsException;
import com.mercadolibre.melifrescosg9w31.exceptions.BadRequestException;
import com.mercadolibre.melifrescosg9w31.exceptions.NotFoundException;
import com.mercadolibre.melifrescosg9w31.exceptions.UnauthorizedException;
import com.mercadolibre.melifrescosg9w31.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class InboundOrderValidator {

    private final IWarehouseRepRepository warehouseRepRepository;
    private final IWarehouseRepository warehouseRepository;
    private final ISectorRepository sectorRepository;
    private final IProductRepository productRepository;
    private final IInboundOrderRepository inboundOrderRepository;
    private final IBatchRepository batchRepository;

    public WarehouseRep validateAndGetRepresentative(Long authenticatedRepId) {
        return warehouseRepRepository
                .findByUser_Id(authenticatedRepId)
                .orElseThrow(
                        () ->
                                new NotFoundException(
                                        "Representative with ID " + authenticatedRepId + " not found."));
    }

    public Warehouse validateAndGetWarehouse(Integer warehouseCode) {
        return warehouseRepository
                .findByWarehouseCode(warehouseCode)
                .orElseThrow(
                        () -> new NotFoundException("Warehouse with code " + warehouseCode + " not found."));
    }

    public void validateRepresentativeWarehouseAccess(
            WarehouseRep representative, Warehouse warehouse) {
        if (representative.getWarehouse() == null
                || !representative.getWarehouse().getId().equals(warehouse.getId())) {
            throw new UnauthorizedException(
                    "Representative "
                            + representative.getName()
                            + " does not belong to warehouse "
                            + warehouse.getWarehouseCode()
                            + ".");
        }
    }

    public Sector validateAndGetSector(Warehouse warehouse, Integer sectionCode) {
        return sectorRepository
                .findByWarehouseIdAndSectorCode(warehouse.getId(), sectionCode)
                .orElseThrow(
                        () ->
                                new NotFoundException(
                                        "Sector with code "
                                                + sectionCode
                                                + " in warehouse "
                                                + warehouse.getWarehouseCode()
                                                + " not found."));
    }

    public void validateOrderNumberUniqueness(Integer orderNumber) {
        if (inboundOrderRepository.findInboundOrderByOrderNumber(orderNumber).isPresent()) {
            throw new AlreadyExistsException(
                    "InboundOrder with order number " + orderNumber + " already exists.");
        }
    }

    public void validateBatchStock(List<BatchStockDTO> batchStock) {
        if (batchStock == null || batchStock.isEmpty()) {
            throw new BadRequestException(
                    "Batch stock list cannot be null or empty for an inbound order.");
        }
    }

    public Product validateAndGetProduct(Long productId, Integer batchNumber) {
        return productRepository
                .findById(productId)
                .orElseThrow(
                        () ->
                                new NotFoundException(
                                        "Product with ID " + productId + " not found in batch " + batchNumber));
    }

    public InboundOrder validateInboundOrderExist(Integer orderNumber) {
        return inboundOrderRepository
                .findInboundOrderByOrderNumber(orderNumber)
                .orElseThrow(
                        () ->
                                new BadRequestException(
                                        "InboundOrder with order number " + orderNumber + " not exists."));
    }

    public void validateProductType(Product product, Sector targetSector) {
        validateProductTypeCategoryMatch(product, targetSector);
        validateNoOtherSectorsWithSameProductHaveSpace(product, targetSector);
    }

    private void validateProductTypeCategoryMatch(Product product, Sector targetSector) {
        if (product.getProductType() == null
                || targetSector.getProductType() == null
                || !targetSector.getProductType().getId().equals(product.getProductType().getId())) {

            String productTypeName =
                    product.getProductType() != null ? product.getProductType().getName() : "N/A";
            String sectorTypeName =
                    targetSector.getProductType() != null ? targetSector.getProductType().getName() : "N/A";

            throw new BadRequestException(
                    "Sector with code "
                            + targetSector.getSectorCode()
                            + " (designed for type: "
                            + sectorTypeName
                            + ") is not suitable for product "
                            + product.getName()
                            + " (type: "
                            + productTypeName
                            + ").");
        }
    }

    private void validateNoOtherSectorsWithSameProductHaveSpace(
            Product product, Sector targetSector) {
        List<Batch> existingBatchesInOtherSectors =
                findExistingBatchesInOtherSectors(product, targetSector);

        if (!existingBatchesInOtherSectors.isEmpty()) {
            Set<Sector> occupiedSectors = getOccupiedSectors(existingBatchesInOtherSectors);
            checkForSectorsWithAvailableSpace(product, occupiedSectors);
        }
    }

    private List<Batch> findExistingBatchesInOtherSectors(Product product, Sector targetSector) {
        return batchRepository.findByProductIdAndProductTypeIdExcludingSector(
                product.getId(), product.getProductType().getId(), targetSector.getId());
    }

    private Set<Sector> getOccupiedSectors(List<Batch> batches) {
        return batches.stream().map(Batch::getSector).collect(Collectors.toSet());
    }

    private void checkForSectorsWithAvailableSpace(Product product, Set<Sector> occupiedSectors) {
        occupiedSectors.stream()
                .filter(
                        occupiedSector -> occupiedSector.getCurrentCapacity() < occupiedSector.getMaxCapacity())
                .findFirst()
                .ifPresent(
                        sectorWithSpace -> {
                            throw new BadRequestException(
                                    "Product "
                                            + product.getName()
                                            + " (ID: "
                                            + product.getId()
                                            + ") already exists in Sector with code "
                                            + sectorWithSpace.getSectorCode()
                                            + ", which is not yet full. New batches of this product must be placed there first.");
                        });
    }

    public void validateBatchQuantity(BatchStockDTO batchDto) {
        if (batchDto.getInitialQuantity() <= 0) {
            throw new BadRequestException(
                    "Initial quantity for batch " + batchDto.getBatchNumber() + " must be greater than 0.");
        }
    }

    public void validateSectorCapacity(Sector sector, int totalQuantityToAdd) {
        if (sector.getMaxCapacity() == null) {
            throw new BadRequestException(
                    "Sector " + sector.getSectorCode() + " does not have a maximum capacity defined.");
        }
        if ((sector.getCurrentCapacity() + totalQuantityToAdd) > sector.getMaxCapacity()) {
            throw new BadRequestException(
                    "Adding "
                            + totalQuantityToAdd
                            + " items (total) would exceed sector "
                            + sector.getSectorCode()
                            + " max capacity of "
                            + sector.getMaxCapacity()
                            + ". Current items in sector: "
                            + sector.getCurrentCapacity()
                            + ".");
        }
    }

    public void validateBatchRequest(List<BatchStockDTO> batchStock, Sector sector) {

        batchStock.forEach(
                order -> {
                    validateBatchStock(batchStock);
                    validateBatchQuantity(order);
                    Product product = validateAndGetProduct(order.getProductId(), order.getBatchNumber());
                    validateProductType(product, sector);
                });
    }
}
