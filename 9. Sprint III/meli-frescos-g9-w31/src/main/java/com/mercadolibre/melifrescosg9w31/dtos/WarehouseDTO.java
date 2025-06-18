package com.mercadolibre.melifrescosg9w31.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseDTO {
    private Integer code;
    private Long totalQuantity;
}
