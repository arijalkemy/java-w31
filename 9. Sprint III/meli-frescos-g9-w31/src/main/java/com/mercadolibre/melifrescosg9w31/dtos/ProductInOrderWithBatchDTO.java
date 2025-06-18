package com.mercadolibre.melifrescosg9w31.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInOrderWithBatchDTO {
    private Long productId;
    private String productName;
    private Integer amount;
    private BigDecimal unitPrice;
    private Long batchId;
    private LocalDate batchExpireDate;
}
