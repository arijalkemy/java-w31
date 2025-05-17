package co.com.mercadolibre.joyerialasperlas.service;

import co.com.mercadolibre.joyerialasperlas.dto.JewelryDto;

import java.util.List;

public interface IJewelryService {

    List<JewelryDto> getAll();
    JewelryDto save(JewelryDto jewelryDto);
    JewelryDto update(JewelryDto jewelryDto, Long id);
    void delete(Long id);
}
