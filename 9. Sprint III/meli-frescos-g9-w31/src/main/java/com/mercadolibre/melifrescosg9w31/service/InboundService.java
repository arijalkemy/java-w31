package com.mercadolibre.melifrescosg9w31.service;

import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.InboundOrderRequest;
import com.mercadolibre.melifrescosg9w31.dtos.response.ResponseBatchStockWrapperDTO;
import com.mercadolibre.melifrescosg9w31.entity.*;
import com.mercadolibre.melifrescosg9w31.mapper.BatchMapper;
import com.mercadolibre.melifrescosg9w31.mapper.InboundOrderMapper;
import com.mercadolibre.melifrescosg9w31.repository.IInboundOrderRepository;
import com.mercadolibre.melifrescosg9w31.service.validator.InboundOrderValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class InboundService implements IInboundService {

    private final IInboundOrderRepository inboundOrderRepository;
    private final InboundOrderValidator validator;
    private final BatchProcessor batchProcessor;
    private final BatchMapper batchMapper;

    @Override
    public ResponseBatchStockWrapperDTO newInboundOrder(
            InboundOrderRequest request, Long authenticatedRepId) {

        validator.validateBatchStock(request.getBatchStock());
        validator.validateOrderNumberUniqueness(request.getOrderNumber());

        WarehouseRep representative = validator.validateAndGetRepresentative(authenticatedRepId);
        Warehouse warehouse =
                validator.validateAndGetWarehouse(request.getSection().getWarehouseCode());
        validator.validateRepresentativeWarehouseAccess(representative, warehouse);
        Sector sector = validator.validateAndGetSector(warehouse, request.getSection().getSectorCode());

        int totalQuantityToAdd =
                request.getBatchStock().stream().mapToInt(BatchStockDTO::getInitialQuantity).sum();
        validator.validateSectorCapacity(sector, totalQuantityToAdd);

        request
                .getBatchStock()
                .forEach(
                        batchDto -> {
                            validator.validateBatchQuantity(batchDto);
                            var product =
                                    validator.validateAndGetProduct(
                                            batchDto.getProductId(), batchDto.getBatchNumber());
                            validator.validateProductType(product, sector);
                        });

        InboundOrder savedInboundOrder = createAndSaveInboundOrder(request, representative, warehouse);
        List<Batch> createdBatches =
                batchProcessor.processBatches(request.getBatchStock(), sector, savedInboundOrder);

        List<BatchStockDTO> response =
                createdBatches.stream().map(batchMapper::convertToBatchDTO).collect(Collectors.toList());

        return new ResponseBatchStockWrapperDTO(response);
    }

    private InboundOrder createAndSaveInboundOrder(
            InboundOrderRequest request, WarehouseRep representative, Warehouse warehouse) {
        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setOrderNumber(request.getOrderNumber());
        inboundOrder.setOrderDate(request.getOrderDate());
        inboundOrder.setRep(representative);
        inboundOrder.setWarehouse(warehouse);

        return inboundOrderRepository.save(inboundOrder);
    }

    @Transactional
    @Override
    public ResponseBatchStockWrapperDTO updateInboundOrder(
            InboundOrderRequest inboundOrderRequest, Long authenticatedRepId) {
        // Validate the inbound order request
        InboundOrder inboundOrder =
                validator.validateInboundOrderExist(inboundOrderRequest.getOrderNumber());

        WarehouseRep representative = validator.validateAndGetRepresentative(authenticatedRepId);

        Warehouse warehouse =
                validator.validateAndGetWarehouse(inboundOrderRequest.getSection().getWarehouseCode());

        validator.validateRepresentativeWarehouseAccess(representative, warehouse);

        Sector sector =
                validator.validateAndGetSector(warehouse, inboundOrderRequest.getSection().getSectorCode());

        int totalQuantityToAdd =
                inboundOrderRequest.getBatchStock().stream()
                        .mapToInt(BatchStockDTO::getInitialQuantity)
                        .sum();

        validator.validateSectorCapacity(sector, totalQuantityToAdd);

        validator.validateBatchRequest(inboundOrderRequest.getBatchStock(), sector);

        List<Batch> updatedData = batchProcessor.updateBatches(inboundOrder, inboundOrderRequest.getBatchStock());

        inboundOrder.setOrderDate(inboundOrderRequest.getOrderDate());

        inboundOrderRepository.save(inboundOrder);

        return InboundOrderMapper.convertToResponseDTO(updatedData);
    }


}
