package com.mercadolibre.melifrescosg9w31.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BatchItemResponseDTO {
        private Integer batchNumber;
        private Long productId;
        private Long productTypeId;
        private String dueDate;
        private Integer currentQuantity;
}
