package com.mercadolibre.melifrescosg9w31.dtos.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseBatchStockWrapperDTO {
    @JsonProperty("batch_stock")
    private List<BatchStockDTO> batchStock;
}
