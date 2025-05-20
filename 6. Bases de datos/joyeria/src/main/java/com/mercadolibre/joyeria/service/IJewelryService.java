package com.mercadolibre.joyeria.service;

import com.mercadolibre.joyeria.dto.RequestJewelryDto;
import com.mercadolibre.joyeria.model.Jewelry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IJewelryService {
    public String addJewelry(RequestJewelryDto jewelry);
    public List<Jewelry> getAllJewelry();
    public String deleteJewelry(Long id);
    public Jewelry editJewelry(Long id, RequestJewelryDto jewelry);
}
