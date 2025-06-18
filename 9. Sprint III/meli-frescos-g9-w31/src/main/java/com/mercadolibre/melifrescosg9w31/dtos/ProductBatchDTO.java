package com.mercadolibre.melifrescosg9w31.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBatchDTO {
    private SectionDTO section;
    @JsonProperty("product_id")
    private Long id;
    private List<BatchStockDTO> batchStock;
}
