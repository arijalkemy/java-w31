package com.mercadolibre.melifrescosg9w31.mapper;

import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import com.mercadolibre.melifrescosg9w31.dtos.ProductBatchDTO;
import com.mercadolibre.melifrescosg9w31.dtos.SectionDTO;
import com.mercadolibre.melifrescosg9w31.entity.Batch;

import java.util.List;

public abstract class ProductBatchMapper {
    static public ProductBatchDTO toProductBatchStockDTO(List<Batch> batch, Long productId) {
        SectionDTO sectionDTO = new SectionDTO(batch.get(0).getSector().getSectorCode(),
                batch.get(0).getSector().getWarehouse().getWarehouseCode());
        List<BatchStockDTO> batchStockDTO = batch.stream().map(BatchStockMapper::toBatchStockDTO).toList();
        return new ProductBatchDTO(sectionDTO, productId, batchStockDTO);
    }
}
