package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.ClothingItemDto;
import com.mercadolibre.showroom.dto.SaleDto;
import com.mercadolibre.showroom.model.Sale;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {

    SaleDto save(SaleDto saleDto);
    void delete(String id);
    SaleDto findById(String id);
    List<SaleDto> findAll();
    SaleDto update(String id, SaleDto saleDto);

    List<SaleDto> findByDate(LocalDate parsedDate);

    List<ClothingItemDto> getClothingItemsBySaleNumber(String number);
}
