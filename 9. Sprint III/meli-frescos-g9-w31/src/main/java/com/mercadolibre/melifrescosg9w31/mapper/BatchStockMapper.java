package com.mercadolibre.melifrescosg9w31.mapper;

import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import com.mercadolibre.melifrescosg9w31.entity.Batch;

public abstract class BatchStockMapper {
    static public BatchStockDTO toBatchStockDTO(Batch batch) {
        return new BatchStockDTO(batch.getBatchNumber(), batch.getActualQuantity(), batch.getExpireDate());
    }
}
