package com.mercadolibre.melifrescosg9w31.mapper;

import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.BatchItemResponseDTO;
import com.mercadolibre.melifrescosg9w31.entity.Batch;
import com.mercadolibre.melifrescosg9w31.entity.InboundOrder;
import com.mercadolibre.melifrescosg9w31.entity.Product;
import com.mercadolibre.melifrescosg9w31.entity.Sector;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@NoArgsConstructor
public class BatchMapper {

    static public BatchItemResponseDTO toBatchItemResponseDTO(Batch batch) {
        return new BatchItemResponseDTO(batch.getBatchNumber(), batch.getProduct().getId(), batch.getProduct().getProductType().getId(), batch.getExpireDate().toString(), batch.getActualQuantity());
    }

    public Batch createBatchFromDTO(
            BatchStockDTO batchDto, Product product, Sector sector, InboundOrder inboundOrder) {
        Batch batch = new Batch();
        batch.setBatchNumber(batchDto.getBatchNumber());
        batch.setProduct(product);
        batch.setRegistrationTemp(BigDecimal.valueOf(batchDto.getCurrentTemperature()));
        batch.setMinimumTemp(BigDecimal.valueOf(batchDto.getMinimumTemperature()));
        batch.setInitialQuantity(batchDto.getInitialQuantity());
        batch.setActualQuantity(batchDto.getInitialQuantity());
        batch.setManufacturingDatetime(batchDto.getManufacturingTime());
        batch.setExpireDate(batchDto.getDueDate());
        batch.setSector(sector);
        batch.setInboundOrder(inboundOrder);
        return batch;
    }

    public BatchStockDTO convertToBatchDTO(Batch batch) {
        Integer batchNumberInt = convertBatchNumberSafely(batch);

        return BatchStockDTO.builder()
                .batchNumber(batchNumberInt)
                .productId(batch.getProduct().getId())
                .currentTemperature(
                        batch.getRegistrationTemp() != null ? batch.getRegistrationTemp().doubleValue() : null)
                .minimumTemperature(
                        batch.getMinimumTemp() != null ? batch.getMinimumTemp().doubleValue() : null)
                .initialQuantity(batch.getInitialQuantity())
                .currentQuantity(batch.getActualQuantity())
                .manufacturingDate(
                        batch.getManufacturingDatetime() != null
                                ? LocalDate.from(batch.getManufacturingDatetime())
                                : null)
                .manufacturingTime(batch.getManufacturingDatetime())
                .dueDate(batch.getExpireDate())
                .build();
    }

    private Integer convertBatchNumberSafely(Batch batch) {
        try {
            return batch.getBatchNumber();
        } catch (ArithmeticException e) {
            throw new IllegalStateException(
                    "Batch number "
                            + batch.getBatchNumber()
                            + " is too large to fit in an Integer for the response DTO.",
                    e);
        }
    }
}