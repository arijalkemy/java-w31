package com.meli.jewelry.app.service;

import com.meli.jewelry.app.dto.JewelDto;
import com.meli.jewelry.app.model.Jewel;

import java.util.List;

public interface IJewelService {

    List<JewelDto> getAllJewels();
    JewelDto findJewel(Long id);
    void save(JewelDto jewel);
    void delete(Long id);
    void update(Long id, JewelDto jewel);


}
