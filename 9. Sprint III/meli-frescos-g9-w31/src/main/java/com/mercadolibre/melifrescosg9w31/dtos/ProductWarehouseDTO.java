package com.mercadolibre.melifrescosg9w31.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWarehouseDTO {
    private Long product_id;
    List<WarehouseDTO> warehouses;
}
