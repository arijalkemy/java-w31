package com.mercadolibre.melifrescosg9w31.service;

import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import com.mercadolibre.melifrescosg9w31.entity.Batch;
import com.mercadolibre.melifrescosg9w31.entity.InboundOrder;
import com.mercadolibre.melifrescosg9w31.entity.Product;
import com.mercadolibre.melifrescosg9w31.entity.Sector;
import com.mercadolibre.melifrescosg9w31.exceptions.BadRequestException;
import com.mercadolibre.melifrescosg9w31.mapper.BatchMapper;
import com.mercadolibre.melifrescosg9w31.repository.IBatchRepository;
import com.mercadolibre.melifrescosg9w31.repository.IProductRepository;
import com.mercadolibre.melifrescosg9w31.repository.ISectorRepository;
import com.mercadolibre.melifrescosg9w31.service.validator.InboundOrderValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BatchProcessor {

    private final IBatchRepository batchRepository;
    private final ISectorRepository sectorRepository;
    private final InboundOrderValidator validator;
    private final BatchMapper batchMapper;
    private final IProductRepository productRepository;

    public List<Batch> processBatches(
            List<BatchStockDTO> batchStock, Sector sector, InboundOrder inboundOrder) {
        int totalQuantityToAdd = calculateTotalQuantity(batchStock);

        validator.validateSectorCapacity(sector, totalQuantityToAdd);

        List<Batch> createdBatches =
                batchStock.stream()
                        .map(batchDto -> processSingleBatch(batchDto, sector, inboundOrder))
                        .toList();

        updateSectorCapacity(sector, totalQuantityToAdd);
        return createdBatches;
    }

    private Batch processSingleBatch(
            BatchStockDTO batchDto, Sector sector, InboundOrder inboundOrder) {
        validator.validateBatchQuantity(batchDto);

        Product product =
                validator.validateAndGetProduct(batchDto.getProductId(), batchDto.getBatchNumber());
        validator.validateProductType(product, sector);

        Batch batch = batchMapper.createBatchFromDTO(batchDto, product, sector, inboundOrder);
        return batchRepository.save(batch);
    }

    private int calculateTotalQuantity(List<BatchStockDTO> batchStock) {
        return batchStock.stream().mapToInt(BatchStockDTO::getInitialQuantity).sum();
    }

    private void updateSectorCapacity(Sector sector, int totalQuantityToAdd) {
        sector.setCurrentCapacity(sector.getCurrentCapacity() + totalQuantityToAdd);
        sectorRepository.save(sector);
    }

    public List<Batch> updateBatches(InboundOrder order, List<BatchStockDTO> batchStockDTOs) {
        List<Batch> updatedData = new ArrayList<>();
        for (BatchStockDTO batchDTO : batchStockDTOs) {
            // Buscar el batch existente por batch_number y inbound_order_id
            Batch existingBatch =
                    batchRepository
                            .findByBatchNumberAndInboundOrderId(batchDTO.getBatchNumber(), order.getId())
                            .orElseThrow(
                                    () ->
                                            new BadRequestException(
                                                    String.format(
                                                            "Batch not found with batch_number: %d for InboundOrder id: %d.",
                                                            batchDTO.getBatchNumber(), order.getId())));
            // Actualizar el batch existente
            updatedData.add(updateBatchData(existingBatch, batchDTO));
            batchRepository.save(existingBatch);
        }
        return updatedData;
    }

    public Batch updateBatchData(Batch batch, BatchStockDTO dto) {
        batch.setRegistrationTemp(BigDecimal.valueOf(dto.getCurrentTemperature()));
        batch.setMinimumTemp(BigDecimal.valueOf(dto.getMinimumTemperature()));
        batch.setInitialQuantity(dto.getInitialQuantity());
        batch.setActualQuantity(dto.getCurrentQuantity());
        batch.setManufacturingDatetime(dto.getManufacturingTime());
        batch.setExpireDate(dto.getDueDate());

        Product product =
                productRepository
                        .findById(dto.getProductId())
                        .orElseThrow(
                                () ->
                                        new EntityNotFoundException(
                                                "Product not found with id: " + dto.getProductId() + "."));
        batch.setProduct(product);

        return batch;
    }
}
