package com.bootcamp.showroom.mapper;

import com.bootcamp.showroom.dto.SaleDTO;
import com.bootcamp.showroom.model.Clothing;
import com.bootcamp.showroom.model.Sale;

import java.time.LocalDate;
import java.util.List;

public class SaleMapper {
    public static SaleDTO toDTO(Sale sale) {
        return new SaleDTO(
                sale.getNumber(),
                sale.getDate(),
                sale.getTotal(),
                sale.getPaymentMethod(),
                sale.getClothesList().stream().map(ClothingMapper::toDTO).toList()
        );
    }

    public static Sale toEntity(SaleDTO dto, List<Clothing> clothes) {
        return new Sale(
                dto.getNumber(),
                dto.getDate(),
                dto.getTotal(),
                dto.getPaymentMethod(),
                clothes
        );
    }
}
