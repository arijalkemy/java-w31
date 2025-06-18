package com.mercadolibre.melifrescosg9w31.mapper;

import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.ResponseBatchStockWrapperDTO;
import com.mercadolibre.melifrescosg9w31.entity.Batch;

import java.util.List;
import java.util.stream.Collectors;

public class InboundOrderMapper {

    public static ResponseBatchStockWrapperDTO convertToResponseDTO(List<Batch> batches) {
        List<BatchStockDTO> batchStockList = batches.stream()
                .map(InboundOrderMapper::convertBatchToResponseDTO)
                .collect(Collectors.toList());

        return new ResponseBatchStockWrapperDTO(batchStockList);
    }

    private static BatchStockDTO convertBatchToResponseDTO(Batch batch) {
        BatchStockDTO dto = new BatchStockDTO();

        dto.setBatchNumber(batch.getBatchNumber());
        dto.setProductId(batch.getProduct().getId());

        // Convertir BigDecimal a Double para las temperaturas
        dto.setCurrentTemperature(batch.getRegistrationTemp().doubleValue());
        dto.setMinimumTemperature(batch.getMinimumTemp().doubleValue());

        dto.setInitialQuantity(batch.getInitialQuantity());
        dto.setCurrentQuantity(batch.getActualQuantity());

        // Extraer solo la fecha del manufacturing_datetime
        dto.setManufacturingDate(batch.getManufacturingDatetime().toLocalDate());
        dto.setManufacturingTime(batch.getManufacturingDatetime());

        dto.setDueDate(batch.getExpireDate());

        return dto;
    }
}
